package PawInc.entities.cells.microbes;

import PawInc.entities.cells.microbes.Microbe;

public class Virus extends Microbe {
    public Virus(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(super.getHealth() + super.getVirulence());
        return sb.toString();
    }
}
