import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        ArrayList<List<String>> filters = new ArrayList<>();
        while(true){
            List<String> inputParams = Arrays.asList(scanner.nextLine().split(";"));
            String command = inputParams.get(0);
            if ("Print".equals(command)) {
                break;
            }
            List<String> data = new ArrayList<>();
            for (int i = 1; i < inputParams.size(); i++) {
                data.add(inputParams.get(i));
            }
            if ("Add filter".equals(command)) {
                filters.add(data);
            }
            else {
                filters.remove(data);
            }
        }
        for (List<String> filter : filters) {
            Predicate<String> currentPredicate = s -> s.startsWith("test");
            Predicate<String> startPredicate = s -> s.startsWith(filter.get(1));
            Predicate<String> endPredicate = s -> s.endsWith(filter.get(1));
            Predicate<String> containsPredicate = s -> s.contains(filter.get(1));
            Predicate<String> lengthPredicate = s -> s.length() == Integer.parseInt(filter.get(1));
            switch (filter.get(0)) {
                case "Starts with":
                    currentPredicate = startPredicate;
                    break;
                case "Ends with":
                    currentPredicate = endPredicate;
                    break;
                case "Length":
                    currentPredicate = lengthPredicate;
                    break;
                case "Contains":
                    currentPredicate = containsPredicate;
                    break;
            }
            names.removeIf(currentPredicate);
        }
        System.out.println(Arrays.toString(names.toArray()).replaceAll("[\\[\\],]", ""));
    }
}