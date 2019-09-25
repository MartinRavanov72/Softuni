package PawInc.entities.essentials;

import PawInc.entities.cells.Cell;

import java.util.*;

public class Cluster {
    private String id;
    private int rows;
    private int cols;
    private List<Cell> cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void addCell(String id, Cell cell){
        this.cells.add(cell);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("----Cluster ").append(this.getId()).append(System.lineSeparator());
        List<Cell> cells = new ArrayList<>(this.cells);
        Comparator<Cell> comp = (a, b) -> Integer.compare(a.getPositionRow(), b.getPositionRow());
        Comparator<Cell> comp1 = (a, b) -> Integer.compare(a.getPositionCol(), b.getPositionCol());
        Collections.sort(cells, comp.thenComparing(comp1));
        for (int i = 0; i < this.cells.size(); i++) {
            sb.append(cells.get(i).toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
