package PawInc.factories;

import PawInc.entities.cells.microbes.Bacteria;

public final class BacteriaFactory {
    private BacteriaFactory() {
    }

    public static Bacteria createBacteria (String cellId, int health, int positionRow, int positionCol, int additionalProperty){
        return new Bacteria(cellId, health, positionRow, positionCol, additionalProperty);
    }
}
