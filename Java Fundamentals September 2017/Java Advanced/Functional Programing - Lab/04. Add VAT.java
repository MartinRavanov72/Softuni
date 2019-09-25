import java.text.DecimalFormat;
        import java.util.*;
        import java.util.function.Function;
        import java.util.function.Predicate;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputParams = scanner.nextLine().split(", ");
        Function<String, Double> vat = x -> Double.parseDouble(x) * 1.2;
        System.out.println("Prices with VAT:");
        for (int i = 0; i < inputParams.length; i++) {
            System.out.println(String.format("%.2f", vat.apply(inputParams[i])).replace(".", ","));
        }
    }
}