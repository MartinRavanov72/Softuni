package a_DefiningClassesEx.animals;

import a_DefiningClassesEx.foods.Food;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten;

    Animal(String animalName, Double animalWeight) {
        this.setAnimalName(animalName);
        this.setAnimalWeight(animalWeight);
    }

    public String getAnimalName() {
        return this.animalName;
    }

    private void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public double getAnimalWeight() {
        return this.animalWeight;
    }

    private void setAnimalWeight(Double animalWeight) {
        this.animalWeight = animalWeight;
    }

    int getFoodEaten() {
        return this.foodEaten;
    }

    void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Meat")) {
            System.out.println(this.getClass().getSimpleName() + "s are not eating that type of food!");
            food.setQuantity(0);
        }
        this.setFoodEaten(food.getQuantity());
    }
}
