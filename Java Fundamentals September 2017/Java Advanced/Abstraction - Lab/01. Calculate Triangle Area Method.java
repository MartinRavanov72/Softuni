import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double base = scanner.nextDouble();
        double height = scanner.nextDouble();
        double area = calculateArea(base, height);
        System.out.printf("Area = %.2f", area);
    }

    private static double calculateArea(double base, double height) {
        return (base * height) / 2;
    }
}