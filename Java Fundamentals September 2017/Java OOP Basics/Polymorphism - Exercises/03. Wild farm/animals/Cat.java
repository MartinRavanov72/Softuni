package a_DefiningClassesEx.animals;

import a_DefiningClassesEx.foods.Food;

import java.text.DecimalFormat;

public class Cat extends Felime {

    private String breed;

    public Cat(String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalWeight, livingRegion);
        this.setBreed(breed);
    }

    private String getBreed() {
        return this.breed;
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    public void makeSound () {
        System.out.println("Meowwww");
    }

    @Override
    public void eat (Food f) {
        this.setFoodEaten(f.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.##");
        return this.getClass().getSimpleName() + "[" + this.getAnimalName() + ", " + this.getBreed() + ", " +
                df.format(this.getAnimalWeight()) + ", " + this.getLivingRegion() +", " + this.getFoodEaten() + "]";
    }
}
