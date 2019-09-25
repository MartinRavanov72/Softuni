package b_secondPrinciple.commands;

import b_secondPrinciple.contracts.AttackGroup;
import b_secondPrinciple.contracts.Command;
import b_secondPrinciple.contracts.ObservableTarget;

public class GroupTargetCommand implements Command {

    private ObservableTarget target;
    private AttackGroup group;

    public GroupTargetCommand(AttackGroup group, ObservableTarget target) {
        this.target = target;
        this.group = group;
    }

    @Override
    public void execute() {
        group.groupTarget(target);
    }
}