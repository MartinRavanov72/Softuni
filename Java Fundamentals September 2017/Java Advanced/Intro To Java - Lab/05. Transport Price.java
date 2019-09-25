import java.math.BigDecimal;
import java.util.Scanner;


public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int km = Integer.parseInt(scanner.nextLine());
        String partOfDay = scanner.nextLine();
        double initialTaxTaxi = 0.7;
        double dayTimeTaxi = 0.79;
        double nightTimeTaxi = 0.90;
        double busTax = 0.09;
        double trainTax = 0.06;
        double tax;
        if (km < 20){
            if (partOfDay.equals("day")){
                tax = dayTimeTaxi*km + initialTaxTaxi;
            }
            else{
                tax = nightTimeTaxi*km + initialTaxTaxi;
            }
        }
        else if (km >= 20 && km < 100){
            tax = busTax*km;
        }
        else{
            tax = trainTax*km;
        }
        System.out.printf("%.2f", tax);
    }
}