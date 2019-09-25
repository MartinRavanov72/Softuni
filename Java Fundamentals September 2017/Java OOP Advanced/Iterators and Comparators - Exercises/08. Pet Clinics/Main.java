package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(scanner.readLine());
        HashMap<String, Pet> pets = new LinkedHashMap<>();
        HashMap<String, Clinic> clinics = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] inputParams = scanner.readLine().split("\\s+");
            switch (inputParams[0]) {
                case "Create":
                    if (inputParams[1].equals("Pet")){
                        Pet pet = new Pet(inputParams[2], Integer.parseInt(inputParams[3]), inputParams[4]);
                        pets.put(inputParams[2], pet);
                    } else {
                        try {
                            Clinic clinic = new Clinic(inputParams[2], Integer.parseInt(inputParams[3]));
                            clinics.put(inputParams[2], clinic);
                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                        }
                    }
                    break;
                case "Add":
                    System.out.println(clinics.get(inputParams[2]).addPet(pets.get(inputParams[1])));
                    break;
                case "Release":
                    System.out.println(clinics.get(inputParams[1]).release());
                    break;
                case "HasEmptyRooms":
                    System.out.println(clinics.get(inputParams[1]).hasEmptyRooms());
                    break;
                case "Print":
                    if (inputParams.length == 3) {
                        System.out.println(clinics.get(inputParams[1]).print(Integer.parseInt(inputParams[2])));
                    } else {
                        System.out.println(clinics.get(inputParams[1]).print());
                    }
                    break;
            }
        }
    }
}