package cresla.models.reactors;

import cresla.interfaces.Container;

public class CryoReactor extends AbstractReactor{
    private int cryoProductionIndex;

    public CryoReactor(Container container, int id, int cryoProductionIndex) {
        super(container, id);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        long result = super.getContainer().getTotalEnergyOutput() * this.cryoProductionIndex;
        if (result > this.getTotalHeatAbsorbing()) {
            result = 0;
        }
        return result;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getContainer().getTotalHeatAbsorbing();
    }

    @Override
    public String toString() {
        return "CryoReactor" + " - " + this.getId() + System.lineSeparator() +
                "Energy Output: " + this.getTotalEnergyOutput() + System.lineSeparator() +
                "Heat Absorbing: " + this.getTotalHeatAbsorbing() + System.lineSeparator() +
                "Modules: " + super.getModuleCount();
    }
}
