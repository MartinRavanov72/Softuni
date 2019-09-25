import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Function;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputParams = scanner.nextLine().split(", ");
        Function<String, Integer> parse = x -> Integer.parseInt(x);
        int sum = 0;
        for (String part : inputParams) {
            sum += parse.apply(part);
        }
        System.out.println("Count = " + inputParams.length);
        System.out.println("Sum = " + sum);
    }
}