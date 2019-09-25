import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DVS {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int [] arr = Arrays.stream(bufferedReader.readLine().split( " ")).mapToInt(Integer::parseInt).toArray();
        for (int index = 0; index < arr.length; index++){
            int min = index;
            for (int j = index + 1; j < arr.length; j++){
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            swap(arr, min, index);
        }
        System.out.println(Arrays.toString(arr).replaceAll(",", "").replaceAll("\\[", "").replaceAll("\\]", ""));
    }

    private static void swap(int[] arr, int min, int index) {
        int temp = arr[min];
        arr[min] = arr[index];
        arr[index] = temp;
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