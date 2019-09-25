package PawInc.factories;

import PawInc.entities.cells.blood_cells.RedBloodCell;

public final class RedBloodCellFactory {
    private RedBloodCellFactory() {
    }

    public static RedBloodCell createRedBloodCell (String cellId, int health, int positionRow, int positionCol, int additionalProperty){
        return new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
    }
}
