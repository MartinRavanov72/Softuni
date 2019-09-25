import java.util.*;
import java.util.stream.Collectors;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Integer> keyMaterials = new TreeMap<>();
        TreeMap<String, Integer> junk = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        boolean found = false;
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }
            String[] inputParams = input.split(" ");
            for (int i = 0; i < inputParams.length; i += 2) {
                int value = Integer.parseInt(inputParams[i]);
                String material = inputParams[i + 1].toLowerCase();
                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    keyMaterials.replace(material, keyMaterials.get(material) + value);
                    if (keyMaterials.get(material) >= 250) {
                        switch (material) {
                            case "motes":
                                System.out.println("Dragonwrath obtained!");
                                break;
                            case "shards":
                                System.out.println("Shadowmourne obtained!");
                                break;
                            case "fragments":
                                System.out.println("Valanyr obtained!");
                                break;
                            default:
                                break;
                        }
                        keyMaterials.replace(material, keyMaterials.get(material) - 250);
                        found = true;
                        break;
                    }
                } else {
                    if (junk.containsKey(material)) {
                        junk.replace(material, junk.get(material) + value);
                    } else {
                        junk.put(material, value);
                    }
                }
            }
            if (found) {
                break;
            }
        }
        LinkedHashMap<String, Integer> sortedKeyMaterials = keyMaterials.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        for (String key : sortedKeyMaterials.keySet()) {
            System.out.println(key + ": " + keyMaterials.get(key));
        }
        for (String key : junk.keySet()) {
            System.out.println(key + ": " + junk.get(key));
        }
    }
}