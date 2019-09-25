package a_DefiningClassesEx;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name) {
        if (name.length() > 15 || name == null || "".equals(name) || "".equals(name.trim())) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
        this.toppings = new ArrayList<>();
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public double getCalories() {
        double toppingsCalories = 0;
        for (Topping topping : this.toppings) {
            toppingsCalories+= topping.getCalories();
        }
        return this.dough.getCalories() + toppingsCalories;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.name, this.getCalories());
    }
}
