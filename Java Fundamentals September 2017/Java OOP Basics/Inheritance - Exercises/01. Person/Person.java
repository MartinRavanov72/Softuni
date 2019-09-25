package a_DefiningClassesEx;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        if (name.length() < 3) {
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age must be positive!");
        }
        this.name = name;
        this.age = age;
    }
}
