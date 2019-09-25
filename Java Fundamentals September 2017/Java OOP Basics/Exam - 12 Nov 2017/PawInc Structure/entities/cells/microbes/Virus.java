package PawInc.entities.cells.microbes;

import PawInc.entities.cells.microbes.Microbe;

public class Virus extends Microbe {
    public Virus(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
