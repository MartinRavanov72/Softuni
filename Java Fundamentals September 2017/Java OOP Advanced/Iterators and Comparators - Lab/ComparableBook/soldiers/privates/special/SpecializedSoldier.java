package interfaces.soldiers.privates.special;

import interfaces.soldiers.privates.Private;
import interfaces.interfaces.ISpecializedSoldier;

public abstract class SpecializedSoldier extends Private implements ISpecializedSoldier {
    private String corps;

    SpecializedSoldier(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    private void setCorps(String corps) {
        if (!(corps.equals("Airforces") || corps.equals("Marines"))) {
            throw new IllegalArgumentException("Wrong corps type!");
        }
        this.corps = corps;
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Corps: %s\n", this.corps);
    }
}
