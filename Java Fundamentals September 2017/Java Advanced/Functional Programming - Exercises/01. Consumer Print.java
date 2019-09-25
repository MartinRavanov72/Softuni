import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputParams = scanner.nextLine().split(" ");
        Consumer<String> print = a -> System.out.println(a);
        for (int i = 0; i < inputParams.length; i++) {
            print.accept(inputParams[i]);
        }

    }
}