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
        List<String> nums = Arrays.stream(scanner.readLine().split("\\s+")).collect(Collectors.toList());
        OptionalDouble avg = nums.stream().filter(x -> !x.isEmpty()).mapToDouble(Double::valueOf).filter(x -> x % 2 == 0).min();
        if (avg.isPresent()) {
            System.out.printf("%.2f", avg.getAsDouble());
        }
        else {
            System.out.println("No match");
        }

    }
}