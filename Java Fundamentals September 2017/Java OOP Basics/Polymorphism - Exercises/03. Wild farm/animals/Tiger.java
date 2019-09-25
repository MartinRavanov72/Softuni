package a_DefiningClassesEx.animals;

import a_DefiningClassesEx.foods.Food;

public class Tiger extends Felime {

    public Tiger(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    public void makeSound () {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat (Food f) {
        if (f.getClass().getSimpleName().equals("Vegetable")) {
            System.out.println(this.getClass().getSimpleName() + "s are not eating that type of food!");
            f.setQuantity(0);
        }
        this.setFoodEaten(f.getQuantity());
    }
}
