import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(factorial(n));
    }

    static long factorial(int num){
        if (num == 0)
        {
            return 1;
        }
        return num * factorial(num - 1);
    }
}