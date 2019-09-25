package Avatar;

import Avatar.benders.*;
import Avatar.monuments.AirMonument;
import Avatar.monuments.EarthMonument;
import Avatar.monuments.FireMonument;
import Avatar.monuments.WaterMonument;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        Nation airNation = new Nation("Air");
        Nation fireNation = new Nation("Fire");
        Nation waterNation = new Nation("Water");
        Nation earthNation = new Nation("Earth");
        int cnt = 0;
        List<String> output = new ArrayList<>();
        while(true){
            String[] line = scanner.readLine().split("\\s+");
            if ("quit".equalsIgnoreCase(line[0])) {
                for (int i = 0; i < output.size(); i++) {
                    System.out.println(output.get(i));
                }
                break;
            }
            switch (line[0].toLowerCase()){
                case "bender":
                    switch (line[1].toLowerCase()){
                        case "fire":
                            FireBender fireBender = new FireBender(line[2], Integer.parseInt(line[3]), Double.parseDouble(line[4]));
                            fireNation.addBender(fireBender);
                            break;
                        case "water":
                            WaterBender waterBender = new WaterBender(line[2], Integer.parseInt(line[3]), Double.parseDouble(line[4]));
                            waterNation.addBender(waterBender);
                            break;
                        case "air":
                            AirBender airBender = new AirBender(line[2], Integer.parseInt(line[3]), Double.parseDouble(line[4]));
                            airNation.addBender(airBender);
                            break;
                        case "earth":
                            EarthBender earthBender = new EarthBender(line[2], Integer.parseInt(line[3]), Double.parseDouble(line[4]));
                            earthNation.addBender(earthBender);
                            break;
                    }
                    break;
                case "monument":
                    switch (line[1].toLowerCase()) {
                        case "fire":
                            FireMonument fireMonument = new FireMonument(line[2], Integer.parseInt(line[3]));
                            fireNation.addMonument(fireMonument);
                            break;
                        case "water":
                            WaterMonument waterMonument = new WaterMonument(line[2], Integer.parseInt(line[3]));
                            waterNation.addMonument(waterMonument);
                            break;
                        case "air":
                            AirMonument airMonument = new AirMonument(line[2], Integer.parseInt(line[3]));
                            airNation.addMonument(airMonument);
                            break;
                        case "earth":
                            EarthMonument earthMonument = new EarthMonument(line[2], Integer.parseInt(line[3]));
                            earthNation.addMonument(earthMonument);
                            break;
                    }
                    break;
                case "status":
                    switch (line[1].toLowerCase()) {
                        case "fire":
                            System.out.println(fireNation.toString());
                            break;
                        case "water":
                            System.out.println(waterNation.toString());
                            break;
                        case "air":
                            System.out.println(airNation.toString());
                            break;
                        case "earth":
                            System.out.println(earthNation.toString());
                            break;
                    }
                    break;
                case "war":
                    switch (line[1].toLowerCase()) {
                        case "fire":
                            cnt++;
                            output.add("War " + cnt + " issued by Fire");
                            break;
                        case "water":
                            cnt++;
                            output.add("War " + cnt + " issued by Water");
                            break;
                        case "air":
                            cnt++;
                            output.add("War " + cnt + " issued by Air");
                            break;
                        case "earth":
                            cnt++;
                            output.add("War " + cnt + " issued by Earth");
                            break;
                    }
                    String winningNation = war(airNation, waterNation, fireNation, earthNation);
                    if (!airNation.getName().equalsIgnoreCase(winningNation)) {
                        airNation = new Nation("Air");
                    }
                    if (!waterNation.getName().equalsIgnoreCase(winningNation)) {
                        waterNation = new Nation("Water");
                    }
                    if (!fireNation.getName().equalsIgnoreCase(winningNation)) {
                        fireNation = new Nation("Fire");
                    }
                    if (!earthNation.getName().equalsIgnoreCase(winningNation)) {
                        earthNation = new Nation("Earth");
                    }
                    break;

            }
        }
    }

    private static String war(Nation airNation, Nation waterNation, Nation fireNation, Nation earthNation) {
        Nation winningNation1;
        if (airNation.getTotalPower() > waterNation.getTotalPower()) {
            winningNation1 = airNation;
        } else {
            winningNation1 = waterNation;
        }
        Nation winningNation2;
        if (fireNation.getTotalPower() > earthNation.getTotalPower()) {
            winningNation2 = fireNation;
        } else {
            winningNation2 = earthNation;
        }
        Nation winningNation;
        if (winningNation1.getTotalPower() > winningNation2.getTotalPower()) {
            winningNation = winningNation1;
        } else {
            winningNation = winningNation2;
        }
        return winningNation.getName();
    }
}
