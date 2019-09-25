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
        List<String> numbers = Arrays.stream(scanner.readLine().split("\\s+")).collect(Collectors.toList());
        numbers.stream().map(x -> x.toUpperCase()).forEach(x -> System.out.print(x+ " "));
        System.out.println();
    }
}