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
        OptionalInt sum = Arrays.stream(scanner.readLine().split("\\s+")).filter(x -> x.matches("-?\\d+(\\.\\d+)?")).mapToInt(Integer::parseInt).reduce((x1, x2) -> x1 + x2);
        if (sum.isPresent()) {
            System.out.println(sum.getAsInt());
        }
        else {
            System.out.println("No match");
        }

    }
}