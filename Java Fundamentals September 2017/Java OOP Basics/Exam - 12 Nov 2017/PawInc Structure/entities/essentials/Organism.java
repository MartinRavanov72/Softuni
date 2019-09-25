package PawInc.entities.essentials;

import PawInc.entities.cells.Cell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Organism {
    private String name;
    private List<Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Cluster> getClusters() {
        return Collections.unmodifiableList(clusters);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Organism - ").append(this.getName()).append(System.lineSeparator())
                .append("--Clusters: ").append(this.getClusters().size()).append(System.lineSeparator())
                .append("--Cells: ");
        long cnt = 0;
        for (Cluster cluster : this.getClusters()) {
            cnt+= cluster.getCells().size();
        }
        sb.append(cnt).append(System.lineSeparator());
        for (Cluster cluster : this.clusters) {
            sb.append(cluster.toString());
        }
        sb.append(System.lineSeparator());
        return sb.toString().trim();
    }
}
