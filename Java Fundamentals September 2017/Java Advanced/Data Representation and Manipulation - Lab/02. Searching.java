import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lineParams = scanner.nextLine().split(" ");
        int[] arr = new int[lineParams.length];
        for (int i = 0; i < lineParams.length; i++) {
            arr[i] = Integer.parseInt(lineParams[i]);
        }
        int key = scanner.nextInt();
        System.out.println(binarySearch(arr, key, 0, arr.length));
    }

    private static int binarySearch(int[] arr, int key, int start, int end) {
        if (start < end) {
            int middle = (end + start) / 2;
            if (key > arr[middle]) {
                return binarySearch(arr, key, middle + 1, end);
            }
            else if (key < arr[middle]) {
                return binarySearch(arr, key, start, middle);
            }
            else {
                return middle;
            }
        }
        return -1;
    }
}