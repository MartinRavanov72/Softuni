import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());
        int n = scanner.nextInt();
        Collections.reverse(nums);
        nums.removeIf(k -> k % n == 0);
        System.out.println(Arrays.toString(nums.toArray()).replaceAll("[\\[\\],]", ""));
    }
}