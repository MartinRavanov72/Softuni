import java.util.ArrayDeque;
import java.util.Scanner;
 
public class TruckTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String[]> pumps = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            pumps.offer(scanner.nextLine().split(" "));
        }
        int index = 0;
        while (true) {
            long fuel = 0;
            boolean found = false;
            for (String[] currentPump : pumps) {
                long currentfuel = Integer.parseInt(currentPump[0]);
                long currentDistance = Integer.parseInt(currentPump[1]);
                fuel += currentfuel;
                if (fuel < currentDistance){
                    found = true;
                    break;
                }
                fuel -= currentDistance;
            }
            if (!found){
                System.out.println(index);
                break;
            }
            pumps.offer(pumps.pop());
            index++;
        }
    }
}