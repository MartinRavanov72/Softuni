import java.util.*;
import java.util.stream.Collectors;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Long>> data = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("report")) {
            String[] inputParams = input.split("\\|");
            String town = inputParams[0];
            String country = inputParams[1];
            Long population = Long.parseLong(inputParams[2]);
            if (data.containsKey(country)){
                if (data.get(country).containsKey(town)){
                    data.get(country).replace(town, data.get(country).get(town) + population);
                } 
                else {
                    data.get(country).put(town, population);
                }
            } 
            else {
                LinkedHashMap<String, Long> townPopulation = new LinkedHashMap<>();
                townPopulation.put(town, population);
                data.put(country, townPopulation);
            }
            input = scanner.nextLine();
        }
        LinkedHashMap<String, Long> result = new LinkedHashMap<>();
        for (String key : data.keySet()) {
            LinkedHashMap<String, Long> sorted = data.get(key).entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (element1, element2) -> element1, LinkedHashMap::new));
            Long totalPopulation = 0L;
            String towns = "";
            for (String key2 : sorted.keySet()) {
                Long townPopulation = data.get(key).get(key2);
                totalPopulation += townPopulation;
                towns += "=>" + key2 + ": " + townPopulation + "\n";
            }
            towns = key + " (total population: " + totalPopulation + ")" + "\n" + towns.substring(0,towns.length()-1);
            result.put(towns, totalPopulation);
        }
        LinkedHashMap<String, Long> sorted = result.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (element1, element2) -> element1, LinkedHashMap::new));
        for (String key : sorted.keySet()) {
            System.out.println(key);
        }
    }
}
