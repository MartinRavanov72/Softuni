package a_DefiningClassesEx;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Car> cars = new LinkedList<>();
        int n = Integer.parseInt(scanner.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.readLine().split("\\s+");
            String model = input[0];
            Integer engineSpeed = Integer.parseInt(input[1]);
            Integer enginePower = Integer.parseInt(input[2]);
            Integer cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            Double tire1Pressure = Double.parseDouble(input[5]);
            Integer tire1Age = Integer.parseInt(input[6]);
            Double tire2Pressure = Double.parseDouble(input[7]);
            Integer tire2Age = Integer.parseInt(input[8]);
            Double tire3Pressure = Double.parseDouble(input[9]);
            Integer tire3Age = Integer.parseInt(input[10]);
            Double tire4Pressure = Double.parseDouble(input[11]);
            Integer tire4Age = Integer.parseInt(input[12]);
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tire1 = new Tire(tire1Pressure, tire1Age);
            Tire tire2 = new Tire(tire2Pressure, tire2Age);
            Tire tire3 = new Tire(tire3Pressure, tire3Age);
            Tire tire4 = new Tire(tire4Pressure, tire4Age);
            Tire[] tires = {tire1, tire2, tire3, tire4};
            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }
        String type = scanner.readLine();
        if ("fragile".equals(type)) {
            cars.stream().filter(a -> a.getCargo().getType().equals("fragile"))
                    .filter(Car::checkTyresPressure).forEach(a -> System.out.println(a.getModel()));
        }
        else {
            cars.stream().filter(a -> a.getCargo().getType().equals("flamable"))
                    .filter(a -> a.getEngine().getPower() > 250).forEach(a -> System.out.println(a.getModel()));
        }
    }
}
