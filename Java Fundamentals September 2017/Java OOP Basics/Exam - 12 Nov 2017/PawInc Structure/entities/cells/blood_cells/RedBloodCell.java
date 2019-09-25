package PawInc.entities.cells.blood_cells;

import PawInc.entities.cells.blood_cells.BloodCell;

public class RedBloodCell extends BloodCell {
    private int velocity;

    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.velocity = velocity;
    }

    public int getVelocity() {
        return velocity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("--------Health %d | Velocity %d | Energy %d", super.getHealth(), this.getVelocity(), this.getHealth()) + this.getVelocity());
        return sb.toString();
    }
}
