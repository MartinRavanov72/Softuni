package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Weapon> weapons = new LinkedHashMap<>();
        while (true) {
            String[] inputParams = scanner.readLine().split(";");
            if (inputParams[0].equals("END")) {
                break;
            }
            switch (inputParams[0]) {
                case "Create":
                    weapons.put(inputParams[2], new Weapon(WeaponType.valueOf(inputParams[1]), inputParams[2]));
                    break;
                case "Add":
                    weapons.get(inputParams[1]).addGem(Integer.parseInt(inputParams[2]), GemType.valueOf(inputParams[3]));
                    break;
                case "Remove":
                    weapons.get(inputParams[1]).removeGem(Integer.parseInt(inputParams[2]));
                    break;
                case "Print":
                    System.out.println(weapons.get(inputParams[1]).toString());
                    break;
            }
        }
    }
}