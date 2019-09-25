package a_DefiningClassesEx;

import a_DefiningClassesEx.animals.*;
import a_DefiningClassesEx.foods.Food;
import a_DefiningClassesEx.foods.Meat;
import a_DefiningClassesEx.foods.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        ArrayDeque<Animal> animals = new ArrayDeque<>();
        List<String> result = new ArrayList<>();
        while (true) {
            String[] commandParams = scanner.readLine().split("\\s+");
            if ("end".equalsIgnoreCase(commandParams[0])) {
                break;
            }
            try {
                if (cnt % 2 == 0) {
                    switch (commandParams[0].toLowerCase()) {
                        case "mouse":
                            Mouse mouse = new Mouse(commandParams[1], Double.parseDouble(commandParams[2]), commandParams[3]);
                            animals.push(mouse);
                            mouse.makeSound();
                            break;
                        case "cat":
                            Cat cat = new Cat(commandParams[1], Double.parseDouble(commandParams[2]), commandParams[3], commandParams[4]);
                            animals.push(cat);
                            cat.makeSound();
                            break;
                        case "tiger":
                            Tiger tiger = new Tiger(commandParams[1], Double.parseDouble(commandParams[2]), commandParams[3]);
                            animals.push(tiger);
                            tiger.makeSound();
                            break;
                        case "zebra":
                            Zebra zebra = new Zebra(commandParams[1], Double.parseDouble(commandParams[2]), commandParams[3]);
                            animals.push(zebra);
                            zebra.makeSound();
                            break;
                    }
                } else {
                    Food food = null;
                    switch (commandParams[0].toLowerCase()) {
                        case "vegetable":
                            food = new Vegetable(Integer.parseInt(commandParams[1]));
                            break;
                        case "meat":
                            food = new Meat(Integer.parseInt(commandParams[1]));
                            break;
                    }
                    animals.peek().eat(food);
                    result.add(animals.pop().toString());

                }
                cnt++;
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
        for (String s : result) {
            System.out.println(s);
        }
    }
}
