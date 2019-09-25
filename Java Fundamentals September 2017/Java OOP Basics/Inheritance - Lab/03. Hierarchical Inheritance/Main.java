package a_DefiningClassesEx;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Dog naiden = new Dog();
        naiden.eat();
        naiden.bark();
        Cat azis = new Cat();
        azis.eat();
        azis.meow();
    }
}