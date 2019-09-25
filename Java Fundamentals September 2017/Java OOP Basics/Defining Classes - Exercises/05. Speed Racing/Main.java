package a_DefiningClassesEx;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.readLine());
        for (int i = 0; i < n; i++) {
            String[] carParameters = scanner.readLine().split("\\s+");
            String model = carParameters[0];
            Double fuelAmount = Double.parseDouble(carParameters[1]);
            Double fuelCost = Double.parseDouble(carParameters[2]);
            Car car = new Car(model, fuelAmount, fuelCost);
            cars.put(model, car);
        }
        while (true) {
            String[] command = scanner.readLine().split("\\s+");
            if ("End".equals(command[0])){
                break;
            }
            String carType = command[1];
            Double targetKilometers = Double.parseDouble(command[2]);
            if (cars.containsKey(carType)) {
                if (!cars.get(carType).drive(targetKilometers)){
                    System.out.println("Insufficient fuel for the drive");
                }
            }
        }
        for (Car car : cars.values()) {
            System.out.println(car);
        }
    }
}
