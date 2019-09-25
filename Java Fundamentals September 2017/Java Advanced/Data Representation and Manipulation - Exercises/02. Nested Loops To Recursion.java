import java.util.*;

public class DVS {
    private static int n;
    private static int[] loops;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        loops = new int[n];
        loop(0);
    }
    private static void loop(int current){
        if (current == n) {
            print();
            return;
        }
        for (int i = 1; i <= n; i++) {
            loops[current] = i;
            loop(current + 1);
        }
    }
    private static void print(){
        System.out.println(Arrays.toString(loops).replaceAll("[\\]\\[,]", ""));
    }

}