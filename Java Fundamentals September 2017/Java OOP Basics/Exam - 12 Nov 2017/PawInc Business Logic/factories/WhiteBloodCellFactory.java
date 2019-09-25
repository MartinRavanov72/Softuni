package PawInc.factories;

import PawInc.entities.cells.blood_cells.RedBloodCell;
import PawInc.entities.cells.blood_cells.WhiteBloodCell;

public final class WhiteBloodCellFactory {
    private WhiteBloodCellFactory() {
    }

    public static WhiteBloodCell createWhiteBloodCell (String cellId, int health, int positionRow, int positionCol, int additionalProperty){
        return new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
    }
}
