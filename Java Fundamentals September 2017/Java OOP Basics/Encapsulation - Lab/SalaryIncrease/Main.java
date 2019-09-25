package a_DefiningClassesEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(scanner.readLine());
        ArrayList<Person> persons = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            String[] personParameters = scanner.readLine().split(" ");
            persons.add(new Person(personParameters[0], personParameters[1], Integer.parseInt(personParameters[2]), Double.parseDouble(personParameters[3])));
        }

        int bonus = Integer.parseInt(scanner.readLine());
        for (Person person : persons) {
            person.increaseSalary(bonus);
            System.out.println(person);
        }
    }
}
