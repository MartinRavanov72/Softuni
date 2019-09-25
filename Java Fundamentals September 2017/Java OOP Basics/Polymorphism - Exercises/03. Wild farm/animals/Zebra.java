package a_DefiningClassesEx.animals;

public class Zebra extends Mammal {
    public Zebra(String animlaName, Double animalWeight, String livingRegion) {
        super(animlaName, animalWeight, livingRegion);
    }

    public void makeSound () {
        System.out.println("Zs");
    }
}
