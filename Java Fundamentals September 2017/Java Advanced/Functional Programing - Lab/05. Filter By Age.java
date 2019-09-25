import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] inputParams = scanner.nextLine().split(", ");
            people.put(inputParams[0], Integer.parseInt(inputParams[1]));
        }
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();
        Predicate<Integer> tester = createTester(condition, age);
        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);
        printFilteredStudent(people, tester, printer);
    }
    private static Consumer<Map.Entry<String,Integer>> createPrinter(String format){
        switch (format) {
            case "name age":
                return person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());
            case "name":
                return person -> System.out.printf("%s%n", person.getKey());
            case "age":
                return person -> System.out.printf("%d%n", person.getValue());
            default:
                return null;
        }
    }
    private static Predicate<Integer> createTester(String condition, Integer age) {
        switch (condition) {
            case "younger":
                return x -> x < age;
            case "older":
                return x -> x >= age;
            default:
                return null;
        }
    }
    public static void printFilteredStudent(LinkedHashMap<String, Integer> people, Predicate<Integer> youngerOrOlder, Consumer<Map.Entry<String, Integer>> printer) {
        for (Map.Entry<String, Integer> person : people.entrySet()) {
            if (youngerOrOlder.test(people.get(person.getKey()))) {
                printer.accept(person);
            }
        }
    }
}