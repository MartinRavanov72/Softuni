package b_secondPrinciple.commands;

import b_secondPrinciple.contracts.AttackGroup;
import b_secondPrinciple.contracts.Command;
import b_secondPrinciple.contracts.ObservableTarget;
import b_secondPrinciple.contracts.Target;

public class GroupTargetCommand implements Command {

    private Target target;
    private AttackGroup group;

    public GroupTargetCommand(AttackGroup group, Target target) {
        this.target = target;
        this.group = group;
    }

    @Override
    public void execute() {
        group.groupTarget(target);
    }
}