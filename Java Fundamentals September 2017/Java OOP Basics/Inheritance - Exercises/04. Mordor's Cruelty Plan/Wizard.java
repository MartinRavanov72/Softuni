package a_DefiningClassesEx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Wizard {
    private Mood mood;
    private List<Food> foodEaten;

    public void eat(String[] foodParams){
        this.foodEaten = new ArrayList<>();
        for (String food : foodParams) {
            Food food1 = new Food(food);
            this.foodEaten.add(food1);
        }
        this.setMood();
    }

    private List<Food> getFoodEaten() {
        return Collections.unmodifiableList(this.foodEaten);
    }

    private void setMood() {
        Mood mood = new Mood(this.getFoodEaten());
        this.mood = mood;
    }

    @Override
    public String toString() {
        return this.mood.getPoints() + System.lineSeparator() + this.mood.toString();
    }
}
