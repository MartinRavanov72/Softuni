package a_DefiningClassesEx;

public class Dough {
    private static double WHITE_MODIFIER = 1.5;
    private static double WHOLEGRAIN_MODIFIER = 1.0;
    private static double CRISPY_MODIFIER = 0.9;
    private static double CHEWY_MODIFIER = 1.1;
    private static double HOMEMADE_MODIFIER = 1.0;

    private double calories;

    public Dough(String[] doughParams, double weight) {
        this.calories = weight * 2;
        for (String doughParam : doughParams) {
            switch (doughParam.toLowerCase()) {
                case "white":
                    this.calories *= WHITE_MODIFIER;
                    break;
                case "wholegrain":
                    this.calories *= WHOLEGRAIN_MODIFIER;
                    break;
                case "crispy":
                    this.calories *= CRISPY_MODIFIER;
                    break;
                case "chewy":
                    this.calories *= CHEWY_MODIFIER;
                    break;
                case "homemade":
                    this.calories *= HOMEMADE_MODIFIER;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid type of dough.");

            }
        }
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    public double getCalories() {
        return calories;
    }
}
