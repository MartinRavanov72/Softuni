package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        List<Person> people = new ArrayList<>();
        int equalPeople = 0;
        int notEqualPeople = 0;
        while (true) {
            String[] inputParams = scanner.readLine().split("\\s+");
            if (inputParams[0].equals("END")){
                break;
            }
            Person currentPerson = new Person(inputParams[0], Integer.parseInt(inputParams[1]), inputParams[2]);
            people.add(currentPerson);
        }
        Person p = people.get(Integer.parseInt(scanner.readLine()) - 1);
        for (Person person : people) {
            if (p.compareTo(person) == 0) {
                equalPeople++;
            } else {
                notEqualPeople++;
            }
        }
        equalPeople--;
        if (equalPeople == 0) {
            System.out.println("No matches");
        } else {
            System.out.println(equalPeople + 1 + " " + notEqualPeople + " " + people.size());
        }
    }
}