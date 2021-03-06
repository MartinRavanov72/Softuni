import java.util.*;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, input);
        while (queue.size() > 1){
            for (int i = 1; i < number; i++) {
                queue.offer(queue.poll());
            }
            System.out.println("Removed "+queue.poll());
        }
        System.out.println("Last is "+queue.poll());
    }
}
