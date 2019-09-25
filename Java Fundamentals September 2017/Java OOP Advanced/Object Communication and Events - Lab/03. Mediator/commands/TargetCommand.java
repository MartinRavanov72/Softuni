package b_secondPrinciple.commands;

import b_secondPrinciple.contracts.Attacker;
import b_secondPrinciple.contracts.Command;
import b_secondPrinciple.contracts.Target;

public class TargetCommand implements Command {

    private Attacker attacker;
    private Target target;

    public TargetCommand(Attacker attacker, Target target) {
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void execute() {
        attacker.setTarget(target);
    }
}