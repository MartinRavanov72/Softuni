import java.text.DecimalFormat;
import java.util.*;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, TreeMap<String, int[]>> dragons = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] inputParams = scanner.nextLine().split(" ");
            String type = inputParams[0];
            String name = inputParams[1];
            int health = 250;
            int damage = 45;
            int armor = 10;
            if (!inputParams[2].equals("null")){
                damage = Integer.parseInt(inputParams[2]);
            }
            if (!inputParams[3].equals("null")){
                health = Integer.parseInt(inputParams[3]);
            }
            if (!inputParams[4].equals("null")){
                armor = Integer.parseInt(inputParams[4]);
            }
            int[] params1 = new int[3];
            params1[0] = damage;
            params1[1] = health;
            params1[2] = armor;
            if (dragons.containsKey(type)){
                dragons.get(type).put(name, params1);
            }
            else {
                TreeMap<String, int[]> params2 = new TreeMap<>();
                params2.put(name, params1);
                dragons.put(type, params2);
            }
        }
        DecimalFormat df = new DecimalFormat("0.00");
        String result = "";
        for (String key : dragons.keySet()) {
            result += key + "::(";
            double avgDamage = 0;
            double avgHealth = 0;
            double avgArmor = 0;
            String temp = "";
            for (String key1 : dragons.get(key).keySet()) {
                int d = dragons.get(key).get(key1)[0];
                int h = dragons.get(key).get(key1)[1];
                int a = dragons.get(key).get(key1)[2];
                temp += "-" + key1 + " -> damage: " + d + ", health: " + h + ", armor: " + a + "\n";
                avgDamage += d;
                avgHealth += h;
                avgArmor += a;
            }
            avgDamage /= dragons.get(key).size();
            avgHealth /= dragons.get(key).size();
            avgArmor /= dragons.get(key).size();
            result += df.format(avgDamage) + "/" + df.format(avgHealth) + "/" + df.format(avgArmor) + ")\n";
            result += temp;
        }
        System.out.println(result);
    }
}