package b_secondPrinciple.models;

import b_secondPrinciple.abstractClasses.Royal;
import b_secondPrinciple.contracts.Killed;

public class Footman extends Royal implements Killed{
    private King king;
    private int health;

    public Footman(String name, King king) {
        super(name);
        this.king = king;
        this.health = 2;
    }

    @Override
    public void attacked() {
        System.out.println("Footman " + super.getName() + " is panicking!");
    }

    @Override
    public void killed() {
        this.health --;
        if (this.health <= 0) {
            this.king.removeRoyal(this);
        }
    }
}
