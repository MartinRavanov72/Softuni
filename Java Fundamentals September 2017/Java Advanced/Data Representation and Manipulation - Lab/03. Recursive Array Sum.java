import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DVS {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int [] arr = Arrays.stream(bufferedReader.readLine().split( " ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(sum(arr, 0));
    }

    private static int sum(int[] arr, int i) {
        if (i == arr.length - 1) {
            return arr[i];
        }
        return arr[i] + sum(arr, i + 1);
    }
}