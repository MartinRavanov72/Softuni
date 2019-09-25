package a_DefiningClassesEx;

import java.util.List;

public class Mood {

    private int points;

    public Mood(List<Food> foodEaten) {
        this.points = 0;
        for (Food food : foodEaten) {
            this.points += food.getPoints();
        }

    }

    int getPoints() {
        return this.points;
    }


    @Override
    public String toString() {
        if (this.points < -5) {
            return "Angry";
        }
        if (this.points < 0) {
            return "Sad";
        }
        if (this.points <= 15) {
            return "Happy";
        }
        return "JavaScript";
    }
}
