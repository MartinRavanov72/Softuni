import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        List<Integer> dividors = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());
        BiPredicate<Integer, Integer> predicate = (a, b) -> a % b == 0;
        for (int i = 1; i <= number; i++) {
            boolean isDividable = false;
            for (int dividor : dividors) {
                if (!predicate.test(i, dividor)) {
                    isDividable = true;
                    break;
                }
            }
            if (!isDividable){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}