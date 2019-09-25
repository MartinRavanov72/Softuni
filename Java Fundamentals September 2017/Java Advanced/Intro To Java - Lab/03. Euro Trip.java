import java.math.BigDecimal;
import java.util.Scanner;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double kg = Double.parseDouble(scanner.nextLine());
        BigDecimal priceInLeva = new BigDecimal( kg * 1.20);
        BigDecimal exchangeRate = new BigDecimal("4210500000000");
        BigDecimal priceInMarks = priceInLeva.multiply(exchangeRate);
        System.out.printf("%.2f marks", priceInMarks);
    }
}