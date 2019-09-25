package PawInc.core;

import PawInc.entities.cells.Cell;
import PawInc.entities.cells.blood_cells.RedBloodCell;
import PawInc.entities.cells.blood_cells.WhiteBloodCell;
import PawInc.entities.cells.microbes.Bacteria;
import PawInc.entities.cells.microbes.Fungi;
import PawInc.entities.cells.microbes.Virus;
import PawInc.entities.essentials.Cluster;
import PawInc.entities.essentials.Organism;
import PawInc.factories.*;

import java.util.*;

public class HealthManager {
    private Map<String, Organism> organisms;

    HealthManager() {
        this.organisms = new LinkedHashMap<>();
    }

    public Map<String, Organism> getOrganisms() {
        return organisms;
    }

    public String checkCondition(String organismName) {
        return this.getOrganisms().get(organismName).toString();
    }

    public String createOrganism(String name) {
        if (this.organisms.containsKey(name)) {
            return "Organism " + name + " already exists";
        }
        Organism organism = OrganismFactory.createOrganism(name);
        this.organisms.put(name, organism);
        return "Created organism " + name;
    }

    public String addCluster(String organismName, String id, int rows, int cols) {
        if (!this.organisms.containsKey(organismName)) {
            return "";
        }
        if (this.organisms.get(organismName).getClusters().containsKey(id)) {
            return "";
        }
        Cluster cluster = ClusterFactory.createCluster(id, rows, cols);
        this.organisms.get(organismName).addCluster(id, cluster);
        return "Organism " + organismName + ": Created cluster " + id;

    }

    public String addCell(String organismName, String clusterId, String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        if (!this.organisms.containsKey(organismName)) {
            return "";
        }
        if (!this.organisms.get(organismName).getClusters().containsKey(clusterId)) {
            return "";
        }
        if (positionCol < 0 || positionCol >= this.organisms.get(organismName).getClusters().get(clusterId).getCols() || positionRow < 0 || positionRow >= this.organisms.get(organismName).getClusters().get(clusterId).getRows()) {
            return "";
        }
        Cell cell = null;
        switch (cellType) {
            case "WhiteBloodCell":
                cell = WhiteBloodCellFactory.createWhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "RedBloodCell":
                cell = RedBloodCellFactory.createRedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "Bacteria":
                cell = BacteriaFactory.createBacteria(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "Fungi":
                cell = FungiFactory.createFungi(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "Virus":
                cell = VirusFactory.createVirus(cellId, health, positionRow, positionCol, additionalProperty);
                break;
        }
        this.organisms.get(organismName).getClusters().get(clusterId).addCell(cellId, cell);
        return "Organism " + organismName + ": Created cell " + cellId + " in cluster " + clusterId;
    }

    public String activateCluster(String organismName) {
        if (!this.organisms.containsKey(organismName)) {
            return "";
        }
        if (!(this.organisms.get(organismName).getClusters().size() > 0)) {
            return "";
        }
        Cluster cluster = null;
        for (Cluster cluster1 : this.organisms.get(organismName).getClusters().values()) {
            cluster = cluster1;
            break;
        }
        int rows = cluster.getRows();
        int cols = cluster.getCols();
        Cell currentCell = null;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (Cell cell : cluster.getCells()) {
                    if (cell.getPositionRow() == i && cell.getPositionCol() == j) {
                        currentCell = cell;
                        j = cols;
                        i = rows;
                        break;
                    }
                }
            }
        }
        boolean stop = false;
        for (int i = currentCell.getPositionRow(); !stop && i < rows; i++) {
            for (int j = currentCell.getPositionCol(); j < cols; j++) {
                List<Cell> cells = cluster.getCells();
                for (Cell cell : cells) {
                    if (cell.getPositionRow() == i && cell.getPositionCol() == j && cell != currentCell) {
                        Cell tempCell = currentCell;
                        currentCell = battle(currentCell, cell);
                        if (currentCell == cell) {
                            cells.remove(tempCell);
                            break;
                        } else {
                            cells.remove(cell);
                            break;
                        }
                    }
                }
                if (cluster.getCells().size() == 1) {
                    stop = true;
                    break;
                }
                currentCell.setPositionCol(currentCell.getPositionCol() + 1);
            }
            if (!stop) {
                currentCell.setPositionRow(currentCell.getPositionRow() + 1);
                currentCell.setPositionCol(0);
            }
        }
        this.organisms.get(organismName).removeCluster(cluster.getId());
        this.organisms.get(organismName).addCluster(cluster.getId(), cluster);
        return "Organism " + organismName + ": Activated cluster " + cluster.getId() + ". Cells left: " + cluster.getCells().size();
    }

    private Cell battle(Cell currentCell, Cell cell) {
        if (currentCell.getClass().getSimpleName().equals("RedBloodCell") || currentCell.getClass().getSimpleName().equals("WhiteBloodCell")) {
            currentCell.setHealth(currentCell.getHealth() + cell.getHealth());
            return currentCell;
        } else {
            int cnt = 0;
            while (currentCell.getHealth() >= 0 && cell.getHealth() >= 0) {
                int energy1 = 0;
                int energy2 = 0;
                if (currentCell.getClass().getSimpleName().equals("Bacteria")) {
                    energy1 = (((Bacteria) currentCell).getVirulence() + ((Bacteria) currentCell).getHealth()) / 3;
                } else if (currentCell.getClass().getSimpleName().equals("Fungi")) {
                    energy1 = (((Fungi) currentCell).getVirulence() + ((Fungi) currentCell).getHealth()) / 4;
                } else {
                    energy1 = ((Virus) currentCell).getHealth() + ((Virus) currentCell).getVirulence();
                }
                if (cell.getClass().getSimpleName().equals("Bacteria")) {
                    energy2 = (((Bacteria) cell).getVirulence() + ((Bacteria) cell).getHealth()) / 3;
                } else if (cell.getClass().getSimpleName().equals("Fungi")) {
                    energy2 = (((Fungi) cell).getVirulence() + ((Fungi) cell).getHealth()) / 4;
                } else if (cell.getClass().getSimpleName().equals("Virus")) {
                    energy2 = ((Virus) cell).getHealth() + ((Virus) cell).getVirulence();
                } else if (cell.getClass().getSimpleName().equals("WhiteBloodCell")) {
                    energy2 = (((WhiteBloodCell) cell).getHealth() + ((WhiteBloodCell) cell).getSize()) * 2;
                } else {
                    energy2 = ((RedBloodCell) cell).getHealth() + ((RedBloodCell) cell).getVelocity();
                }
                if (cnt % 2 == 0) {
                    cell.setHealth(cell.getHealth() - energy1);
                } else {
                    currentCell.setHealth(currentCell.getHealth() - energy2);
                }
                cnt++;
            }
            if (currentCell.getHealth() < 0) {
                return cell;
            } else {
                return currentCell;
            }
        }
    }
}
