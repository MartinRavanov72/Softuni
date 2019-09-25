package a_DefiningClassesEx;

import java.util.ArrayList;;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        if (name.isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.name = name;
        this.money = money;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void buy(Product product){
        if (this.money - product.getCost() >= 0) {
            this.products.add(product);
            System.out.println(this.name + " bought " + product.getName());
            this.money-=product.getCost();
        }
        else {
            System.out.println(this.name + " can't afford " + product.getName());
        }
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.name, this.products.size() == 0 ? "Nothing bought" : this.products.stream().map(Product::getName).collect(Collectors.joining(", ")));
    }
}
