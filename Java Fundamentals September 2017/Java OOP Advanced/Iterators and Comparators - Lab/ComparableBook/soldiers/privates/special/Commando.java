package interfaces.soldiers.privates.special;

import interfaces.Mission;
import interfaces.interfaces.ICommando;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Commando extends SpecializedSoldier implements ICommando {

    private List<Mission> missions;

    public Commando(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        missions = new ArrayList<>();
    }

    @Override
    public List<Mission> getMissions() {
        return Collections.unmodifiableList(this.missions);
    }

    @Override
    public void addMission(Mission m) {
        this.missions.add(m);
    }

    @Override
    public String toString() {
        StringBuilder missionsToString = new StringBuilder();
        missionsToString.append("Missions:\n");
        this.missions.forEach(missionsToString::append);
        missionsToString.append(System.lineSeparator());
        return super.toString() + missionsToString;
    }
}