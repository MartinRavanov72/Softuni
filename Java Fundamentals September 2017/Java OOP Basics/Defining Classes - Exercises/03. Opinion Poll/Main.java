package a_DefiningClassesEx;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(scanner.readLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] inputParams = scanner.readLine().split("\\s+");
            Person person = new Person(inputParams[0], Integer.parseInt(inputParams[1]));
            people.add(person);
        }
        Predicate<Person> pred = x -> x.getAge() <= 30;
        Comparator<Person> comp = (x, y) -> x.getName().compareToIgnoreCase(y.getName());
        people.removeIf(pred);
        Collections.sort(people, comp);
        for (Person person : people) {
            System.out.println(person.getName() + " - " + person.getAge());
        }
    }
}
