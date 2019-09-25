package PawInc.entities.cells;

public abstract class Cell {
    private String id;
    private int health;
    private int positionRow ;
    private int positionCol ;

    public Cell(String id, int health, int positionRow, int positionCol) {
        this.id = id;
        this.health = health;
        this.positionRow = positionRow;
        this.positionCol = positionCol;
    }

    public String getId() {
        return id;
    }

    public int getHealth() {
        return health;
    }

    public int getPositionRow() {
        return positionRow;
    }

    public int getPositionCol() {
        return positionCol;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("------Cell ").append(this.getId()).append(" ").append("[").append(this.getPositionRow()).append(",").append(this.getPositionCol()).append("]").append(System.lineSeparator());
        return sb.toString();
    }
}
