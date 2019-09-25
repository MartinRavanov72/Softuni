package PawInc.entities.cells.blood_cells;

import PawInc.entities.cells.Cell;

public abstract class BloodCell extends Cell {
    public BloodCell(String id, int health, int positionRow, int positionCol) {
        super(id, health, positionRow, positionCol);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
