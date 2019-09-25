package PawInc.entities.cells.blood_cells;

import PawInc.entities.cells.blood_cells.BloodCell;

public class WhiteBloodCell extends BloodCell {
    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("--------Health %d | Size %d | Energy %d", super.getHealth(), this.getSize(), (super.getHealth() + this.getSize()) * 2));
        return sb.toString();
    }
}
