package a_DefiningClassesEx.animals;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{
    private String livingRegion;

    Mammal(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, animalWeight);
        this.setLivingRegion(livingRegion);
    }

    String getLivingRegion() {
        return this.livingRegion;
    }

    private void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.##");
        return this.getClass().getSimpleName() + "[" + this.getAnimalName() + ", " +
                df.format(this.getAnimalWeight()) + ", " + this.getLivingRegion() +", " + this.getFoodEaten() + "]";
    }

}
