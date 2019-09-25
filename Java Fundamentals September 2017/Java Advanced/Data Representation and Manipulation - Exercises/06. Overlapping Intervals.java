import java.util.*;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] inputParams = scanner.nextLine().split(",");
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(inputParams[j]);
            }
        }
        boolean result = false;
        for (int i = 0; i < arr.length; i++){
            int min = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j][0] < arr[min][0]){
                    min = j;
                }
            }
            swap(arr, min, i);
        }
        for (int i = 0; i < n - 1; i++) {
            if ((arr[i+1][0] <= arr[i][1] && arr[i+1][0] >= arr[i][0])) {
                result = true;
                break;
            }
        }
        System.out.println(result);
    }

    private static void swap(int[][] arr, int min, int index) {
        int[] temp = arr[min];
        arr[min] = arr[index];
        arr[index] = temp;
    }
}