package app.core;

import app.contracts.*;
import app.factory.ActionFactoryImpl;
import app.factory.TargetableFactoryImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BattlefieldImplementation implements Battlefield {

    private Map<String, Targetable> participants;
    private List<Action> executedActions;
    private Writer writer;
    private TargetableFactory targetableFactory;
    private ActionFactory actionFactory;

    public BattlefieldImplementation(Writer writer) {
        this.executedActions = new ArrayList<>();
        this.participants = new TreeMap<>();
        this.writer = writer;
        this.targetableFactory = new TargetableFactoryImpl();
        this.actionFactory = new ActionFactoryImpl();
    }

    @Override
    public void createAction(String actionName, String... participantNames) {
        try {
            List<Targetable> actionParticipants = new ArrayList<>();
            for (String name : participantNames) {
                if (this.participants.containsKey(name)) {
                    actionParticipants.add(this.participants.get(name));
                } else {
                    writer.writeLine(String.format("%s is not on the battlefield. %s failed.", name, actionName));
                    return;
                }
            }
            Action action = this.actionFactory.create(actionName, participantNames);
            writer.writeLine(action.executeAction(actionParticipants));
            checkForDeadParticipants();
            this.executedActions.add(action);
        } catch (Exception e) {
            writer.writeLine("Action does not exist.");
        }
    }

    @Override
    public void createParticipant(String name, String className) {
        if (this.participants.containsKey(name)) {
            writer.writeLine("Participant with that name already exists.");
            return;
        }
        Targetable participant = null;
        try {
            participant = this.targetableFactory.create(name, className);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        this.participants.put(participant.getName(), participant);
        writer.writeLine(String.format("%s %s entered the battlefield.", participant.getClass().getSimpleName(), participant.getName()));

    }

    @Override
    public void createSpecial(String name, String specialName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void reportParticipants() {
        if (this.participants.size() < 1) {
            writer.writeLine("There are no participants on the battlefield.");
            return;
        }
        for (String name : this.participants.keySet()) {
            writer.writeLine(this.participants.get(name).toString());
            writer.writeLine("* * * * * * * * * * * * * * * * * * * *");
        }
    }

    @Override
    public void reportActions() {
        if (this.executedActions.size() < 1) {
            writer.writeLine("There are no actions on the battlefield.");
            return;
        }

        for (Action executedAction : executedActions) {
            writer.writeLine(executedAction.getClass().getSimpleName());
        }
    }

    private void checkForDeadParticipants() {
        Map<String, Targetable> aliveParticipants = new TreeMap<>();
        for (String name : this.participants.keySet()) {
            if (!this.participants.get(name).isAlive()) {
                writer.writeLine(String.format("%s has been removed from the battlefield.", name));
            } else {
                aliveParticipants.put(name, this.participants.get(name));
            }
        }

        this.participants = aliveParticipants;
    }
}
