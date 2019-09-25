import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lineParams = scanner.nextLine().split(" ");
        int[] arr = new int[lineParams.length];
        for (int i = 0; i < lineParams.length; i++) {
            arr[i] = Integer.parseInt(lineParams[i]);
        }
        reverseArr(arr,0, arr.length - 1);
        System.out.println(Arrays.toString(arr).replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\,", ""));
    }

    private static void reverseArr(int[] arr, int i, int j) {
        if (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            reverseArr(arr, ++i, --j);
        }
    }
}