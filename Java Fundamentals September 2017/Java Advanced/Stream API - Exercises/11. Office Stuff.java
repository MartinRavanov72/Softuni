import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, LinkedHashMap<String, Integer>> supplies = new TreeMap<>();
        int n = Integer.parseInt(scanner.readLine());
        for (int i = 0; i < n; i++) {
            List<String> inputParams = Arrays.stream(scanner.readLine().split("( - )|(\\|)")).filter(x -> !x.isEmpty()).collect(Collectors.toList());
            String company = inputParams.get(0);
            int quantity = Integer.parseInt(inputParams.get(1));
            String material = inputParams.get(2);
            if (supplies.containsKey(company)) {
                if (supplies.get(company).containsKey(material)) {
                    supplies.get(company).put(material, supplies.get(company).get(material) + quantity);
                }
                else {
                    supplies.get(company).put(material, quantity);
                }
            }
            else {
                LinkedHashMap<String, Integer> materials = new LinkedHashMap<>();
                materials.put(material, quantity);
                supplies.put(company, materials);
            }
        }

        for (String key : supplies.keySet()) {
            String output = "";
            output += key + ": ";
            for (String key1 : supplies.get(key).keySet()){
                output += key1 + "-" + supplies.get(key).get(key1) + ", ";
            }
            System.out.println(output.substring(0, output.length() - 2));
        }

    }
}