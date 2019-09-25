package a_DefiningClassesEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        List<Person> people = new ArrayList<>();
        Map<String, Product> products = new LinkedHashMap<>();

        try {
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    String[] line = scanner.readLine().split(";");
                    for (String aLine : line) {
                        String[] lineParams = aLine.split("=");
                        Person person = new Person(lineParams[0], Double.parseDouble(lineParams[1]));
                        people.add(person);
                    }
                }
                else {
                    String[] line = scanner.readLine().split(";");
                    for (String aLine : line) {
                        String[] lineParams = aLine.split("=");
                        Product product = new Product(lineParams[0], Double.parseDouble(lineParams[1]));
                        products.put(lineParams[0], product);
                    }
                }
            }
            while (true) {
                String[] line = scanner.readLine().split("\\s+");
                if ("END".equals(line[0])) {
                    break;
                }
                for (Person person : people) {
                    if (person.getName().equals(line[0])) {
                        person.buy(products.get(line[1]));
                    }
                }
            }
            people.forEach(System.out::println);

        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
