import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MaximumElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        Predicate<String> currentPredicate = s -> s.startsWith("test");
        while (true){
            String input = scanner.nextLine();
            if ("Party!".equals(input)) {
                break;
            }
            String[] inputParams = input.split("\\s+");
            Predicate<String> startPredicate = s -> s.startsWith(inputParams[2]);
            Predicate<String> endPredicate = s -> s.endsWith(inputParams[2]);
            Predicate<String> lengthPredicate = s -> s.length() == Integer.parseInt(inputParams[2]);
            switch (inputParams[1]){
                case "StartsWith":
                    currentPredicate = startPredicate;
                    break;
                case "EndsWith":
                    currentPredicate = endPredicate;
                    break;
                case "Length":
                    currentPredicate = lengthPredicate;
                    break;
            }
            switch (inputParams[0]){
                case "Remove":
                    names.removeIf(currentPredicate);
                    break;
                case "Double":
                    List<String> result = new ArrayList<>();
                    for (int i = 0; i < names.size(); i++) {
                        if (currentPredicate.test(names.get(i))) {
                            result.add(names.get(i));
                        }
                        result.add(names.get(i));
                    }
                    names = result;
                    break;
            }
        }
        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        }
        else {
            System.out.println(Arrays.toString(names.toArray()).replaceAll("[\\[\\]]", "") + " are going to the party!");
        }
    }
}