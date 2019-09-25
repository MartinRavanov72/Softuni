import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputParams = scanner.nextLine().split(" ");
        Integer[] nums = new Integer[inputParams.length];
        for (int i = 0; i < inputParams.length; i++) {
            nums[i] = Integer.parseInt(inputParams[i]);
        }
        Function<Integer[], Integer> minNum = numbers -> Collections.min(Arrays.asList(numbers));
        System.out.println(minNum.apply(nums));
    }
}