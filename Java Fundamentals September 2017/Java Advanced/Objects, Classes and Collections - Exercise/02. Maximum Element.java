import java.util.ArrayDeque;
import java.util.Scanner;
 
public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> queue2 = new ArrayDeque<>();
 
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            if (input.equals("3")){
                System.out.println(queue2.peek());
            }
            else if (input.equals("2")){
                if (!queue.isEmpty()){
                    queue2.remove(queue.peek());
                    queue.pop();
                }
            }
            else {
                int num = Integer.parseInt(input.split(" ")[1]);
                queue.push(num);
                if (queue2.isEmpty() || queue2.peek() <= num){
                    queue2.push(num);
                }
                else {
                    queue2.addLast(num);
                }
            }
        }
    }
}