package a_DefiningClassesEx;

public class Kitten extends Cat{
    public Kitten(String name, int age) {
        super(name, age, "Female");
    }

    @Override
    public String produceSound() {
        return "Miau";
    }
}