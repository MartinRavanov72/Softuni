import java.util.*;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, input);
        int cnt = 1;
        while (queue.size() > 1){
            for (int i = 1; i < number; i++) {
                queue.offer(queue.poll());
            }
            if(IsPrime(cnt)) {
                System.out.println("Prime " + queue.peek());
            } 
            else {
                System.out.println("Removed " + queue.poll());
            }
            cnt++;
        }
        System.out.println("Last is "+ queue.poll());

    }

    private static boolean IsPrime(int counter) {
        if (counter == 1){
            return false;
        }
        for (int i = 2; i < counter; i++) {
            if(counter % i == 0){
                return false;
            }
        }
        return true;
    }
}


