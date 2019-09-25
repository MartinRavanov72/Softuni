import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputParams = scanner.nextLine().split(" ");
        int lowerBound = Integer.parseInt(inputParams[0]);
        int upperBound = Integer.parseInt(inputParams[1]);
        String command = scanner.nextLine();
        Predicate<String> isEven = s -> s.equals("even");
        if (isEven.test(command)) {
            printEven(lowerBound, upperBound);
        }
        else {
            printOdd(lowerBound, upperBound);
        }
        System.out.println();
    }

    private static void printOdd(int lowerBound, int upperBound) {
        for (int i = lowerBound; i <= upperBound; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
    }

    private static void printEven(int lowerBound, int upperBound) {
        for (int i = lowerBound; i <= upperBound; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
    }
}