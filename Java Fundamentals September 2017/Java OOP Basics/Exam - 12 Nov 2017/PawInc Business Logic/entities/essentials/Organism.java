package PawInc.entities.essentials;

import PawInc.entities.cells.Cell;

import java.util.*;

public class Organism {
    private String name;
    private LinkedHashMap<String, Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public LinkedHashMap<String, Cluster> getClusters() {
        return clusters;
    }

    public void addCluster (String id, Cluster cluster){
        this.clusters.put(id, cluster);
    }

    public void removeCluster (String id){
        this.clusters.remove(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Organism - ").append(this.getName()).append(System.lineSeparator())
                .append("--Clusters: ").append(this.getClusters().size()).append(System.lineSeparator())
                .append("--Cells: ");
        long cnt = 0;
        for (Cluster cluster : this.getClusters().values()) {
            cnt+= cluster.getCells().size();
        }
        sb.append(cnt).append(System.lineSeparator());
        for (Cluster cluster : this.clusters.values()) {
            sb.append(cluster.toString());
        }
        sb.append(System.lineSeparator());
        return sb.toString().trim();
    }
}
