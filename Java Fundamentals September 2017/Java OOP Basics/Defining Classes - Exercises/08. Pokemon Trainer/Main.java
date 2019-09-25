package a_DefiningClassesEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();
        while (true){
            String[] inputParams = scanner.readLine().split("\\s+");
            if ("Tournament".equals(inputParams[0])){
                break;
            }
            String trainerName = inputParams[0];
            String pokemonName = inputParams[1];
            String pokemonElement = inputParams[2];
            Integer pokemonHealth = Integer.valueOf(inputParams[3]);
            Trainer trainer = new Trainer(trainerName);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainer.addPokemon(pokemon);
            if (trainers.containsKey(trainerName)) {
                trainers.get(trainerName).addPokemon(pokemon);
            }
            else {
                trainers.put(trainerName, trainer);
            }
        }
        while (true) {
            String element = scanner.readLine();
            if ("End".equals(element)){
                break;
            }
            for (String key : trainers.keySet()) {
                if (trainers.get(key).checkForElement(element)){
                    trainers.get(key).addBadge();
                }
                else {
                    trainers.get(key).increaseHealth();
                }
            }
        }

        trainers.entrySet().stream().sorted((t1, t2) -> {
            return Integer.compare(t2.getValue().getNumberOfBadges(), t1.getValue().getNumberOfBadges());
        }).forEach(trainer -> System.out.println(trainer.getValue()));
    }
}
