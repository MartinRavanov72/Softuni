package PawInc.factories;

import PawInc.entities.cells.microbes.Fungi;

public final class FungiFactory {
    private FungiFactory() {
    }

    public static Fungi createFungi (String cellId, int health, int positionRow, int positionCol, int additionalProperty){
        return new Fungi(cellId, health, positionRow, positionCol, additionalProperty);
    }
}
