package a_DefiningClassesEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static LinkedHashMap<String, Person> people = new LinkedHashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String line = scanner.readLine();
        String personName = "";
        if (!line.contains("/")) {
            personName = line;
        }
        String personBirthday = "";
        if (line.contains("/")) {
            personBirthday = line;
        }
        Person personWanted = new Person(personName, personBirthday);
        List<Person> fullDataPeople = new ArrayList<>();
        List<Person> halfDataPeople = new ArrayList<>();
        while (true) {
            line = scanner.readLine();
            if ("End".equals(line)) {
                break;
            }
            String[] input = line.split(" - ");
            switch (input.length) {
                case 1:
                    String[] newSplit = line.split("\\s+");
                    String name = newSplit[0] + " " + newSplit[1];
                    String birthday = newSplit[2];
                    fullDataPeople.add(new Person(name, birthday));
                    break;
                case 2:
                    String nameOrBirthdayParent = input[0];
                    String nameOrBirthdayChild = input[1];
                    Person parent = nameOrBirthdayParent.contains("/") ? new Person("", nameOrBirthdayParent) :
                            new Person(nameOrBirthdayParent, "");
                    Person child = nameOrBirthdayChild.contains("/") ? new Person("", nameOrBirthdayChild) :
                            new Person(nameOrBirthdayChild, "");
                    parent.addChild(child);
                    child.addParent(parent);
                    halfDataPeople.add(parent);
                    halfDataPeople.add(child);
                    break;
            }
        }
        halfDataPeople.forEach(partialPerson -> {
            fullDataPeople.stream().filter(fullPerson -> fullPerson.getBirthday().equals(partialPerson.getBirthday()) ||
                    fullPerson.getName().equals(partialPerson.getName())).forEach(fullPerson -> {
                partialPerson.getParents().forEach(fullPerson::addParent);
                partialPerson.getChildren().forEach(fullPerson::addChild);
                partialPerson.changeName(fullPerson.getName());
                partialPerson.changeBirthday(fullPerson.getBirthday());
            });
        });
        fullDataPeople.forEach(person -> {
            if (person.getName().equals(personWanted.getName()) ||
                    person.getBirthday().equals(personWanted.getBirthday())) {
                System.out.println(person);
            }
        });
    }
}
