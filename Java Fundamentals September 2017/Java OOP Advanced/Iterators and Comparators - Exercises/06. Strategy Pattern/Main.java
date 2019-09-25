package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Person> personsName = new TreeSet<>(new ComparatorAge());
        TreeSet<Person> personsAge = new TreeSet<>(new ComparatorName());
        int n = Integer.parseInt(scanner.readLine());
        for (int i = 0; i < n; i++) {
            String[] inputParams = scanner.readLine().split("\\s+");
            Person person = new Person(inputParams[0], Integer.parseInt(inputParams[1]));
            personsAge.add(person);
            personsName.add(person);
        }
        for (Person person : personsAge) {
            System.out.println(person.toString());
        }
        for (Person person : personsName) {
            System.out.println(person.toString());
        }
    }
}