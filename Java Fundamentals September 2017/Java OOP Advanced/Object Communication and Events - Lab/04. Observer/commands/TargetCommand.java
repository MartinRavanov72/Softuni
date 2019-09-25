package b_secondPrinciple.commands;

import b_secondPrinciple.contracts.Attacker;
import b_secondPrinciple.contracts.Command;
import b_secondPrinciple.contracts.ObservableTarget;

public class TargetCommand implements Command {

    private Attacker attacker;
    private ObservableTarget target;

    public TargetCommand(Attacker attacker, ObservableTarget target) {
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void execute() {
        attacker.setTarget(target);
    }
}