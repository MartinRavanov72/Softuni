import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(scanner.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        HashMap<String, Predicate<Integer>> predicates = new HashMap<>();
        while (true) {
            String[] inputParams = scanner.readLine().split(";");
            if ("Forge".equals(inputParams[0])){
                break;
            }
            Predicate<Integer> condition = findPredicate(inputParams[1], Integer.valueOf(inputParams[2]), input);
            switch (inputParams[0]) {
                case "Exclude":
                    predicates.put(inputParams[1] + inputParams[2], condition);
                    break;
                case "Reverse":
                    predicates.remove(inputParams[1] + inputParams[2]);
                    break;
            }
        }
        for (int i = 0; i < input.length; i++) {
            boolean found = false;
            for (Predicate<Integer> predicate : predicates.values()){
                if (predicate.test(i)){
                    found = true;
                    break;
                }
            }
            if (!found){
                System.out.print(input[i] + " ");
            }
        }
    }

    private static Predicate<Integer> findPredicate(String condition, Integer sum, int[] input) {
        switch (condition){
            case "Sum Left":
                return index -> (index > 0 ? input[index - 1] : 0) + input[index] == sum;
            case "Sum Right":
                return index -> (index < input.length-1 ? input[index + 1] : 0) + input[index] == sum;
            default:
                return index -> (index > 0 ? input[index - 1] : 0) + input[index] +
                        (index < input.length-1 ? input[index + 1] : 0) == sum;
        }
    }
}