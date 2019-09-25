import java.util.*;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = "stop";
        if (!line1.equals("stop")) {
            line2 = scanner.nextLine();
        }
        LinkedHashMap<String, Integer> resources = new LinkedHashMap();
        while(!line1.equals("stop") || !line2.equals("stop")){
            if (resources.containsKey(line1)) {
                resources.put(line1, resources.get(line1) + Integer.parseInt(line2));
            }
            else {
                resources.put(line1, Integer.parseInt(line2));
            }
            line1 = scanner.nextLine();
            if (line1.equals("stop")) {
                break;
            }
            line2 = scanner.nextLine();
        }
        for (String key : resources.keySet()) {
            System.out.println(key + " -> " + resources.get(key));
        }
    }
}
