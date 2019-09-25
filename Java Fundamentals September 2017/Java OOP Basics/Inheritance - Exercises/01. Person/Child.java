package a_DefiningClassesEx;

import java.util.ArrayList;

public class Child extends Person{

    public Child(String name, int age) {
        super(name, age);
        if (age > 15) {
            throw new IllegalArgumentException("Child's age must be lesser than 15!");
        }
    }

    @Override
    public String toString() {
        return "Name: " + super.name + ", Age: " + super.age;
    }
}
