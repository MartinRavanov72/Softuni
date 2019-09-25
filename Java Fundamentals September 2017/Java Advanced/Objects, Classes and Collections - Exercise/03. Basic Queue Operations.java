import java.util.ArrayDeque;
import java.util.Scanner;
 
public class QueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        scanner.nextLine();
        String[] inputParams = scanner.nextLine().split("[\\s+]");
        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(inputParams[i]));
        }
        for (int i = 0; i < s; i++) {
            queue.poll();
        }
        if (queue.contains(x)) {
            System.out.println("true");
        }
        else {
            int smallestElement = Integer.MAX_VALUE;
            int i = 0;
            if (queue.size() == 0) {
                smallestElement = 0;
            }
            else {
                while (i < queue.size()) {
                    if (queue.peek() < smallestElement) {
                        smallestElement = queue.poll();
                    }
                    else {
                        i++;
                    }
                }
            }
            System.out.println(smallestElement);
        }
    }
}
 