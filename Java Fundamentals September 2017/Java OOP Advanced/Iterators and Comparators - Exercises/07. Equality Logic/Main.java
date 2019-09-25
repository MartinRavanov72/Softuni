package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Person> set1 = new TreeSet<>(new PersonComparator());
        HashSet<Person> set2 = new HashSet<>();
        int n = Integer.parseInt(scanner.readLine());
        for (int i = 0; i < n; i++) {
            String[] inputParams = scanner.readLine().split("\\s+");
            Person person = new Person(inputParams[0], Integer.parseInt(inputParams[1]));
            set1.add(person);
            set2.add(person);
        }
        System.out.println(set1.size());
        System.out.println(set2.size());
    }
}