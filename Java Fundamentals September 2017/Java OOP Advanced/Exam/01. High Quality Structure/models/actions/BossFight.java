package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;
import app.models.Config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BossFight implements Action {
    public BossFight() {}

    @Override
    public String executeAction(List<Targetable> participants) {
        String errorMessage = "There should be at least 1 participant for boss fight!";
        StringBuilder sb = new StringBuilder();
        if (!participants.get(0).getClass().getSimpleName().equals("Boss")) {
            return "Invalid boss.";
        }
        if (participants.size() < 2) {
            return errorMessage;
        }
        Targetable boss = participants.get(0);
        List<Targetable> fighters = new ArrayList<>(participants.subList(1, participants.size()));
        Targetable killer = null;
        while (boss.isAlive() && this.areParticipantsAlive(fighters)){
            for (Targetable participant : fighters) {
                participant.attack(boss);
                if (boss.isAlive()) {
                    boss.attack(participant);
                }else {
                    killer = participant;
                    break;
                }
            }
        }
        if (boss.isAlive()){
            sb.append("Boss has slain them all!");
        }else {
            for (Targetable participant : fighters) {
                if (participant.isAlive()) {
                    if (participant.getName().equals(killer.getName())) {
                        participant.receiveReward(boss.getGold());
                        participant.receiveReward(Config.BOSS_INDIVIDUAL_REWARD);
                    } else {
                        participant.levelUp();
                        participant.receiveReward(Config.BOSS_INDIVIDUAL_REWARD);
                    }
                }
            }
            sb.append("Boss has been slain by:").append(System.lineSeparator());
            Collections.sort(fighters, Comparator.comparing(Targetable::getName));
            for (Targetable participant : fighters) {
                sb.append(participant.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    private boolean areParticipantsAlive(List<Targetable> fighters){
        for (Targetable participant : fighters) {
            if (participant.isAlive()) {
                return true;
            }
        }
        return true;
    }
}
