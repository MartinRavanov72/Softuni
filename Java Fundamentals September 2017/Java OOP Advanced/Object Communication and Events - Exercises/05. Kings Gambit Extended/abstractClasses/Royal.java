package b_secondPrinciple.abstractClasses;

import b_secondPrinciple.contracts.Attacked;
import b_secondPrinciple.contracts.Killed;

public abstract class Royal implements Attacked, Killed{
    private String name;

    protected Royal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
