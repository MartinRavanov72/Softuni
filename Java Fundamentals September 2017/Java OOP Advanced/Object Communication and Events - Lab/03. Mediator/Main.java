package b_secondPrinciple;


import b_secondPrinciple.abstractClasses.Logger;
import b_secondPrinciple.commands.CommandExecutor;
import b_secondPrinciple.commands.GroupAttackCommand;
import b_secondPrinciple.commands.GroupTargetCommand;
import b_secondPrinciple.contracts.AttackGroup;
import b_secondPrinciple.contracts.Command;
import b_secondPrinciple.contracts.Executor;
import b_secondPrinciple.contracts.ObservableTarget;
import b_secondPrinciple.loggers.CombatLogger;
import b_secondPrinciple.loggers.EventLogger;
import b_secondPrinciple.models.Dragon;
import b_secondPrinciple.models.Group;
import b_secondPrinciple.models.Warrior;

public class Main {
    public static void main(String[] args) {
        Logger combatLogger = new CombatLogger();
        Logger eventLogger = new EventLogger();
        combatLogger.setSuccessor(eventLogger);
        AttackGroup group = new Group();
        group.addMember(new Warrior("Ivan", 10 , combatLogger));
        group.addMember(new Warrior("Azis", 13, combatLogger));
        ObservableTarget dragon = new Dragon("Miro", 10, 25, combatLogger);
        Executor commandExecutor = new CommandExecutor();
        Command groupTarget = new GroupTargetCommand(group, dragon);
        Command attackCommand = new GroupAttackCommand(group);
        commandExecutor.executeCommand(groupTarget);
        commandExecutor.executeCommand(attackCommand);
    }
}