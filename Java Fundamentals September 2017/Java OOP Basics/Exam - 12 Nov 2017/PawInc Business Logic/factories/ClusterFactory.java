package PawInc.factories;

import PawInc.entities.essentials.Cluster;
import PawInc.entities.essentials.Organism;

public final class ClusterFactory {
    private ClusterFactory() {}

    public static Cluster createCluster (String id, int rows, int cols){
        return new Cluster(id, rows, cols);
    }
}
