import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        draw(n);
    }

    private static void draw(int n) {
        if (n <= 0) {
            return;
        }
        System.out.println(String.join("", Collections.nCopies(n, "*")));
        draw(n - 1);
        System.out.println(String.join("", Collections.nCopies(n, "#")));
    }
}