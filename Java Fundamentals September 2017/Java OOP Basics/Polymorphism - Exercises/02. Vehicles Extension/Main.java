package a_DefiningClassesEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String[] carParams = scanner.readLine().split("\\s+");
        String[] truckParams = scanner.readLine().split("\\s+");
        String[] busParams = scanner.readLine().split("\\s+");
        int n = Integer.parseInt(scanner.readLine());
        Vehicle car = new Car(Double.parseDouble(carParams[1]), Double.parseDouble(carParams[2]), Double.parseDouble(carParams[3]));
        Vehicle truck = new Truck(Double.parseDouble(truckParams[1]), Double.parseDouble(truckParams[2]), Double.parseDouble(truckParams[3]));
        Bus bus = new Bus(Double.parseDouble(busParams[1]), Double.parseDouble(busParams[2]), Double.parseDouble(busParams[3]));
        for (int i = 0; i < n; i++) {
            String[] inputParams = scanner.readLine().split("\\s+");
            try {
                if (inputParams[0].toLowerCase().equals("drive") || inputParams[0].toLowerCase().equals("driveempty")) {
                    if (inputParams[1].toLowerCase().equals("car")) {
                        car.drive(Double.parseDouble(inputParams[2]));
                    } else if (inputParams[1].toLowerCase().equals("truck")) {
                        truck.drive(Double.parseDouble(inputParams[2]));
                    } else {
                        if (inputParams[0].toLowerCase().equals("driveempty")) {
                            bus.driveEmpty(Double.parseDouble(inputParams[2]));
                        } else {
                            bus.drive(Double.parseDouble(inputParams[2]));
                        }
                    }
                    DecimalFormat df = new DecimalFormat("0.##");
                    System.out.println(inputParams[1] + " travelled " + df.format(Double.parseDouble(inputParams[2])) + " km");
                } else {
                    if (inputParams[1].toLowerCase().equals("car")) {
                        car.refuel(Double.parseDouble(inputParams[2]));
                    } else if (inputParams[1].toLowerCase().equals("truck")) {
                        truck.refuel(Double.parseDouble(inputParams[2]));
                    } else {
                        bus.refuel(Double.parseDouble(inputParams[2]));
                    }
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
