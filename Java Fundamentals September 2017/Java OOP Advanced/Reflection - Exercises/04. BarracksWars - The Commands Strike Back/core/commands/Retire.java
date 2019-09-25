package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

public class Retire extends Command{
    public Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ReflectiveOperationException {
        return this.getRepository().removeUnit(this.getData()[1]);
    }
}
