package a_DefiningClassesEx;

import java.util.ArrayList;
import java.util.Collections;

public class Animal {
    protected ArrayList<Food> foodEaten;

    public Animal() {
        this.setFoodEaten(new ArrayList<>());
    }

    private void setFoodEaten(ArrayList<Food> foodEaten) {
        this.foodEaten = foodEaten;
    }

    public final void eat(Food f) {
        foodEaten.add(f);
    }

    public final void eatAll(Food[] foods) {
        Collections.addAll(foodEaten, foods);
    }
}