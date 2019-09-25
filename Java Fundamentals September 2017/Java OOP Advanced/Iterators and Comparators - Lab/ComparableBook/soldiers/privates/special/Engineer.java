package interfaces.soldiers.privates.special;

import interfaces.Repair;
import interfaces.interfaces.IEngineer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Engineer extends SpecializedSoldier implements IEngineer {

    private List<Repair> repairs;

    public Engineer(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public List<Repair> getRepairs() {
        return Collections.unmodifiableList(this.repairs);
    }

    @Override
    public void addRepair(Repair r) {
        this.repairs.add(r);
    }

    @Override
    public String toString() {
        StringBuilder repairsToString = new StringBuilder();
        repairsToString.append("Repairs:\n");
        this.repairs.forEach(repairsToString::append);
        repairsToString.append(System.lineSeparator());
        return super.toString() + repairsToString;
    }
}