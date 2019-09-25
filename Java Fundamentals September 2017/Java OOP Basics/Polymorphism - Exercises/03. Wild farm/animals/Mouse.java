package a_DefiningClassesEx.animals;

import a_DefiningClassesEx.foods.Food;

public class Mouse extends Mammal {
    public Mouse(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    public void makeSound () {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat (Food f) {
        if (f.getClass().getSimpleName().equals("Meat")) {
            System.out.println("Mice are not eating that type of food!");
            f.setQuantity(0);
        }
        this.setFoodEaten(f.getQuantity());
    }
}
