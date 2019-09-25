package a_DefiningClassesEx;

public class Topping {
    private static double MEAT_MODIFIER = 1.2;
    private static double VEGGIES_MODIFIER = 0.8;
    private static double CHEESE_MODIFIER = 1.1;
    private static double SAUCE_MODIFIER = 0.9;

    private double calories;

    public Topping(String name, double weight) {
        this.calories = weight * 2;
        switch (name.toLowerCase()) {
            case "meat":
                this.calories *= MEAT_MODIFIER;
                break;
            case "veggies":
                this.calories *= VEGGIES_MODIFIER;
                break;
            case "cheese":
                this.calories *= CHEESE_MODIFIER;
                break;
            case "sauce":
                this.calories *= SAUCE_MODIFIER;
                break;
            default:
                throw new IllegalArgumentException("Cannot place " + name + " on top of your pizza.");

        }
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(name + " weight should be in the range [1..50].");
        }
    }

    public double getCalories() {
        return calories;
    }
}
