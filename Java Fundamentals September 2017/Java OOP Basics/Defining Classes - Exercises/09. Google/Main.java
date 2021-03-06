package a_DefiningClassesEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static LinkedHashMap<String, Person> people = new LinkedHashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] input = scanner.readLine().split("\\s+");
            if ("End".equals(input[0])){
                break;
            }
            String personName = input[0];
            String propertyType = input[1];
            String argument1 = input[2];
            String argument2 = input[3];
            switch (propertyType) {
                case "company":
                    if (input.length > 4) {
                        argument1 = "";
                        for (int i = 2; i < input.length -1 ; i++) {
                            argument1 += input[i] + " ";
                        }
                        argument2 = input[input.length-1];
                    }
                    Company company = new Company(argument1.trim(), argument2);
                    updateProperty(personName, company);
                    break;
                case "car":
                    Car car = new Car(argument1, argument2);
                    updateProperty(personName, car);
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon(argument1, argument2);
                    addProperty(personName, pokemon);
                    break;
                case "parents":
                    Parent parent = new Parent(argument1, argument2);
                    addProperty(personName, parent);
                    break;
                case "children":
                    Children children = new Children(argument1, argument2);
                    addProperty(personName, children);
                    break;
                default:
                    break;
            }
        }

        String targetPerson = scanner.readLine();
        System.out.println(people.get(targetPerson));
    }

    private static void addProperty(String personName, Object object) {
        if (people.containsKey(personName)){
            people.get(personName).addProperty(object);
        }
        else {
            Person person = new Person(personName);
            person.addProperty(object);
            people.put(personName, person);
        }
    }

    private static void updateProperty(String personName, Object object) {
        if (people.containsKey(personName)){
            people.get(personName).updateProperty(object);
        }
        else {
            Person person = new Person(personName);
            person.updateProperty(object);
            people.put(personName, person);
        }
    }
}
