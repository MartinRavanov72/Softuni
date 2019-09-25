package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

public abstract class Command implements Executable{

    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    String[] getData() {
        return data;
    }

    Repository getRepository() {
        return repository;
    }

    UnitFactory getUnitFactory() {
        return unitFactory;
    }
}