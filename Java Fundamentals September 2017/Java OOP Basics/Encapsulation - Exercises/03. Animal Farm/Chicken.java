package a_DefiningClassesEx;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        if (name.isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public double getProductivity() {
        return this.calculateProductivity();
    }

    private double calculateProductivity() {
        if (this.age >= 0 && this.age < 6) {
            return 2;
        }
        else if (this.age >= 6 && this.age < 12) {
            return 1;
        }
        else {
            return 0.75;
        }
    }
}
