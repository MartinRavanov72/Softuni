import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        HashMap<String, String> map = new HashMap<>();
        while(!line.equals("search")){
            String[] lineParams = line.split("-");
            map.put(lineParams[0], lineParams[1]);
            line = scanner.nextLine();
        }
        line = scanner.nextLine();
        while(!line.equals("stop")){
            if (map.containsKey(line)) {
                System.out.println(line + " -> " + map.get(line));
            }
            else {
                System.out.println("Contact " + line + " does not exist.");
            }
            line = scanner.nextLine();
        }
    }
}
