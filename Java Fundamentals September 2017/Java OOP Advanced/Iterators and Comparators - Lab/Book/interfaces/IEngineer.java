package interfaces.interfaces;

import interfaces.Repair;

import java.util.List;

public interface IEngineer extends ISpecializedSoldier {
    List<Repair> getRepairs();

    void addRepair(Repair r);
}