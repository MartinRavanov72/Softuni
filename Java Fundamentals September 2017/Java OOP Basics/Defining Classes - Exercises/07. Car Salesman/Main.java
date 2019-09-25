package a_DefiningClassesEx;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int cnt1 = Integer.parseInt(scanner.readLine());
        Map<String, Engine> engines = new LinkedHashMap<>();
        for (int i = 0; i < cnt1; i++) {
            String[] inputParams1 = scanner.readLine().split("\\s+");
            Engine engine = createEngine(inputParams1);
            engines.put(inputParams1[0], engine);
        }
        int cnt2 = Integer.parseInt(scanner.readLine());
        for (int i = 0; i < cnt2; i++) {
            String[] inputParams2 = scanner.readLine().split("\\s+");
            Car car = createCar(inputParams2, engines);
            System.out.println(car);
        }
    }

    private static Car createCar(String[] inputParams2, Map<String, Engine> engines) {
        String model = inputParams2[0];
        Engine engine = engines.get(inputParams2[1]);
        if (inputParams2.length == 2){
            return new Car(model, engine);
        }
        else if (inputParams2.length == 4){
            String weight = inputParams2[2];
            String color = inputParams2[3];
            return new Car(model, engine, weight, color);
        }
        try {
            Integer weight = Integer.parseInt(inputParams2[2]);
            return new Car(model, engine, weight);
        }
        catch (NumberFormatException e){
            String color = inputParams2[2];
            return new Car(model, engine, color);
        }
    }

    private static Engine createEngine(String[] inputParams1) {
        String model = inputParams1[0];
        Integer power = Integer.parseInt(inputParams1[1]);
        if (inputParams1.length == 2){
            return new Engine(model, power);
        }
        else if (inputParams1.length == 4){
            String displacement = inputParams1[2];
            String efficiency = inputParams1[3];
            return new Engine(model, power, displacement, efficiency);
        }
        try {
            Integer displacement = Integer.parseInt(inputParams1[2]);
            return new Engine(model, power, displacement);
        }
        catch (NumberFormatException e){
            String efficiency = inputParams1[2];
            return new Engine(model, power, efficiency);
        }
    }
}
