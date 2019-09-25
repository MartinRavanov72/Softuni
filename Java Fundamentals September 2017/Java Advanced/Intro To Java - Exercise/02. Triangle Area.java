import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;


public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        scanner.nextLine();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        scanner.nextLine();
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();
        double area = 0;
        if ((Math.abs(x1 /y1) == Math.abs(x2 / y2)) && (Math.abs(x2 / y2) == Math.abs(x3 / y3))){

        }
        else{
            area = ((x1 - x3)*(y2 - y1) - (x1 - x2)*(y3 - y1))/2;
        }
        System.out.println(Math.abs(Math.round(area)));
    }
}