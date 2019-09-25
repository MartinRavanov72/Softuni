package PawInc.factories;

import PawInc.entities.cells.microbes.Virus;

public final class VirusFactory {
    private VirusFactory() {
    }

    public static Virus createVirus (String cellId, int health, int positionRow, int positionCol, int additionalProperty){
        return new Virus(cellId, health, positionRow, positionCol, additionalProperty);
    }
}
