package b_secondPrinciple.abstractClasses;

import b_secondPrinciple.contracts.Attacked;

public abstract class Royal implements Attacked{
    private String name;

    protected Royal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
