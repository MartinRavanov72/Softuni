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
        String lineWithCars = scanner.nextLine();
        String[] carsInPark = lineWithCars.split(" ");
        String order = scanner.nextLine();
        int carsSold = 0;
        while (!order.equals("End of customers!")) {
            String[] orderParams = order.split(" ");
            String typeCar = orderParams[0].toLowerCase();
            String seats = orderParams[2];
            String currentCar = typeCar.charAt(0) + seats;
            int price;
            if (Arrays.asList(carsInPark).contains(currentCar)) {
                for (int i = 0; i < carsInPark.length; i++) {
                    if (carsInPark[i].equals(currentCar)) {
                        carsInPark[i] = "dont print";
                        break;
                    }
                }
                price = ((int)typeCar.charAt(0)) * Integer.parseInt(seats);
                System.out.println("Yes, sold for " + price + "$");
                carsSold++;
            }
            else {
                System.out.println("No");
            }

            order = scanner.nextLine();
        }
        boolean dontdo = false;
        String toBePrintedVehiclesLeft = "Vehicles left: ";
        for (int i = 0; i < carsInPark.length; i++) {
            if (!carsInPark[i].equals("dont print")) {
                toBePrintedVehiclesLeft += (carsInPark[i] + "," + " ");
                dontdo = true;
            }
        }
        if (dontdo) {
            toBePrintedVehiclesLeft = toBePrintedVehiclesLeft.substring(0, toBePrintedVehiclesLeft.length() - 2);
        }
        System.out.println(toBePrintedVehiclesLeft);
        System.out.printf("Vehicles sold: %s", carsSold);
    }
}