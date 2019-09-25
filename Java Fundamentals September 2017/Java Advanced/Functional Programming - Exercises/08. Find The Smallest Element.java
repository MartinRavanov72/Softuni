import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());
        Function<List<Integer>, Integer> minNum = numbers -> Collections.min(numbers);
        System.out.println(nums.lastIndexOf(minNum.apply(nums)));
    }
}