package PawInc.entities.cells.microbes;

import PawInc.entities.cells.Cell;

public abstract class Microbe extends Cell {
    private int virulence;

    public Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    public int getVirulence() {
        return virulence;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("--------Health: %d | Virulence: %d | Energy: ", super.getHealth(), this.getVirulence()));
        return sb.toString();
    }
}
