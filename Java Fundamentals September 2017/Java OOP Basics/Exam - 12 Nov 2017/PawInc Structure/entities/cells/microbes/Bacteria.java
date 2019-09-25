package PawInc.entities.cells.microbes;

import PawInc.entities.cells.microbes.Microbe;

public class Bacteria extends Microbe {
    public Bacteria(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
