package b_secondPrinciple.models;

import b_secondPrinciple.abstractClasses.Royal;
import b_secondPrinciple.contracts.Killed;

public class RoyalGuard extends Royal implements Killed{
    private King king;
    private int health;

    public RoyalGuard(String name, King king) {
        super(name);
        this.king = king;
        this.health = 3;
    }

    @Override
    public void attacked() {
        System.out.println("Royal Guard " + super.getName() + " is defending!");
    }

    @Override
    public void killed() {
        this.health --;
        if (this.health <= 0) {
            this.king.removeRoyal(this);
        }
    }
}
