import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, HashMap<String, Long>> data = new HashMap<>();
        while(true){
            String input = scanner.readLine();
            if ("Count em all".equals(input)) {
                break;
            }
            String[] inputParams = input.split(" -> ");
            String region = inputParams[0];
            String meteor = inputParams[1];
            Long count = Long.parseLong(inputParams[2]);
            if (data.containsKey(region)) {
                data.get(region).put(meteor, data.get(region).get(meteor) + count);
            }
            else {
                data.put(region, new HashMap<>());
                if ("Green".equals(meteor)) {
                    data.get(region).put("Green", count);
                    data.get(region).put("Red", 0l);
                    data.get(region).put("Black", 0l);
                }
                else if ("Red".equals(meteor)) {
                    data.get(region).put("Red", count);
                    data.get(region).put("Green", 0l);
                    data.get(region).put("Black", 0l);
                }
                else {
                    data.get(region).put("Black", count);
                    data.get(region).put("Red", 0l);
                    data.get(region).put("Green", 0l);
                }
              
            }
          tidy(data);
          tidy(data);
        }
        tidy(data);
        tidy(data);
        tidy(data);
        print(data);
    }
    
    private static void tidy(HashMap<String, HashMap<String, Long>> data) {
        for (Map.Entry<String, HashMap<String, Long>> kvp : data.entrySet()) {
            for (Map.Entry<String, Long> kvp2 : kvp.getValue().entrySet()) {
                if (kvp2.getKey() == "Green") {
                    long i = kvp2.getValue();
                    if (i >= 1000000) {
                        while(i >= 1000000) {
                            data.get(kvp.getKey()).put("Red", data.get(kvp.getKey()).get("Red") + 1l);
                            i-=1000000;
                        }
                        data.get(kvp.getKey()).put("Green", i);
                    }
                }
                else if (kvp2.getKey() == "Red") {
                    long i = kvp2.getValue();
                    if (i >= 1000000) {
                        while(i >= 1000000) {
                            data.get(kvp.getKey()).put("Black", data.get(kvp.getKey()).get("Black") + 1l);
                            i-=1000000;
                        }
                        data.get(kvp.getKey()).put("Red", i);
                    }
                }
            }
        }
    }
    
    private static void print(HashMap<String, HashMap<String, Long>> data) {
        List<Map.Entry<String, HashMap<String, Long>>> list = new ArrayList<>(data.entrySet());
        Comparator<Map.Entry<String, HashMap<String, Long>>> blackUnits = (x, y) -> y.getValue().get("Black").compareTo(x.getValue().get("Black"));
        Comparator<Map.Entry<String, HashMap<String, Long>>> byLength = (x, y) -> Long.compare(x.getKey().length(), y.getKey().length());
        Comparator<Map.Entry<String, HashMap<String, Long>>> alphabetically1 = (x, y) -> x.getKey().compareToIgnoreCase(y.getKey());
        Collections.sort(list, blackUnits.thenComparing(byLength).thenComparing(alphabetically1));
        for (Map.Entry <String, HashMap<String, Long>> kvp : list) {
            System.out.println(kvp.getKey());
            List<Map.Entry<String, Long>> list2 = new ArrayList<>(kvp.getValue().entrySet());
            Comparator<Map.Entry<String, Long>> defeatedUnits = (x, y) -> Long.compare(y.getValue(), x.getValue());
            Comparator<Map.Entry<String, Long>> alphabetically = (x, y) -> x.getKey().compareToIgnoreCase(y.getKey());
            Collections.sort(list2, defeatedUnits.thenComparing(alphabetically));
            for (Map.Entry<String, Long> kvp2 : list2){
                System.out.printf("-> %1$s : %2$s", kvp2.getKey(), kvp2.getValue());
                System.out.println();
            }
        }
    }
}