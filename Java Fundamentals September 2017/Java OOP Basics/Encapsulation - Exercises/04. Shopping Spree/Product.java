package a_DefiningClassesEx;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        if (name.isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (cost < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
