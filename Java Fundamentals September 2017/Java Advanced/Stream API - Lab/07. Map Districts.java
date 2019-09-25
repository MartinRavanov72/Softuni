import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, List<Integer>> cityData = new HashMap<>();
        List<String> inputParams = Arrays.asList(scanner.readLine().split("\\s+"));
        int targetPopulation = Integer.valueOf(scanner.readLine());
        for (String input : inputParams) {
            String[] parts = input.split(":");
            cityData.putIfAbsent(parts[0], new ArrayList<>());
            cityData.get(parts[0]).add(Integer.parseInt(parts[1]));
        }
        cityData.entrySet().stream()
                .filter(kvp -> kvp.getValue().stream().mapToInt(Integer::valueOf).sum() > targetPopulation)
                .sorted((kvp1, kvp2) -> Integer.compare(
                        kvp2.getValue().stream().mapToInt(Integer::valueOf).sum(),
                        kvp1.getValue().stream().mapToInt(Integer::valueOf).sum()))
                .forEach(kv -> {
                    System.out.print(kv.getKey() + ": " );
                    kv.getValue().stream().sorted((a, b) -> b.compareTo(a)).limit(5).forEach(val -> System.out.print(val + " "));
                    System.out.println();
                });
    }
}