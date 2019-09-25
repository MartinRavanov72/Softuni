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
        List<Integer> numbers = Arrays.stream(scanner.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        numbers.stream().distinct().filter(x -> x>=10 && x <=20).limit(2).forEach(x -> System.out.print(x+ " "));
        System.out.println();
    }
}