package a_DefiningClassesEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(scanner.readLine());
        ArrayList<Person> persons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] inputParams = scanner.readLine().split(" ");
            try {
                persons.add(new Person(inputParams[0], inputParams[1], Integer.valueOf(inputParams[2]), Double.valueOf(inputParams[3])));
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        Team team = new Team("Azis");
        for (Person person : persons) {
            team.addPlayer(person);
        }
        System.out.println("First team have " + team.getFirstTeam().size() + " players");
        System.out.println("Reserve team have " + team.getReserveTeam().size() + " players");
    }
}
