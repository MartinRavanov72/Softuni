package interfaces.interfaces;

import interfaces.Mission;

import java.util.List;

public interface ICommando extends ISpecializedSoldier {
    List<Mission> getMissions();

    void addMission(Mission m);
}
