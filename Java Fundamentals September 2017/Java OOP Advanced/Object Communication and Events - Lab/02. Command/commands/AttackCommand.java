package b_secondPrinciple.commands;

import b_secondPrinciple.contracts.Attacker;
import b_secondPrinciple.contracts.Command;

public class AttackCommand implements Command {

    private Attacker attacker;

    public AttackCommand(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        attacker.attack();
    }
}