package PawInc.core;

import java.util.*;

public class AnimalCenterManager {
    private TreeSet<String> adoptedAnimals;
    private TreeSet<String> cleansedAnimals;

    AnimalCenterManager() {
        this.cleansedAnimals = new TreeSet<>();
        this.adoptedAnimals = new TreeSet<>();
    }
}
