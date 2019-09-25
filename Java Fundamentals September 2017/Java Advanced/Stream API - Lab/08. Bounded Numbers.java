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
        List<Integer> bounds = Arrays.stream(scanner.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> nums = Arrays.stream(scanner.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .filter(x -> Collections.min(bounds) <= x && x <= Collections.max(bounds))
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(nums.toArray()).replaceAll("[\\[\\],]", ""));
    }
}