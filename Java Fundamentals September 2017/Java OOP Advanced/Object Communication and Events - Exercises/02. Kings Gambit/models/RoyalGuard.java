package b_secondPrinciple.models;

import b_secondPrinciple.abstractClasses.Royal;
import b_secondPrinciple.contracts.Killed;

public class RoyalGuard extends Royal implements Killed{
    private King king;

    public RoyalGuard(String name, King king) {
        super(name);
        this.king = king;
    }

    @Override
    public void attacked() {
        System.out.println("Royal Guard " + super.getName() + " is defending!");
    }

    @Override
    public void killed() {
        this.king.removeRoyal(this);
    }
}
