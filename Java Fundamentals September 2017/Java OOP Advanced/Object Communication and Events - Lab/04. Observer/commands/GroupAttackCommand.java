package b_secondPrinciple.commands;

import b_secondPrinciple.contracts.AttackGroup;
import b_secondPrinciple.contracts.Command;

public class GroupAttackCommand implements Command {

    private AttackGroup group;

    public GroupAttackCommand(AttackGroup group) {
        this.group = group;
    }

    @Override
    public void execute() {
        group.groupAttack();
    }
}