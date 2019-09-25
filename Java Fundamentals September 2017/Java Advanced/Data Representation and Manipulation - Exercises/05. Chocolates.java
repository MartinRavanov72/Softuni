import java.util.*;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] inputParams = scanner.nextLine().split(", ");
        int[] arr = new int[inputParams.length];
        for (int i = 0; i < inputParams.length; i++) {
            arr[i] = Integer.parseInt(inputParams[i]);
        }
        int chocolates = scanner.nextInt();
        Arrays.sort(arr);
        int smallestDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= n - chocolates; i++) {
            int[] tempArr = new int[chocolates];
            int cnt = 0;
            for (int j = i; j < chocolates + i; j++) {
                tempArr[cnt] = arr[j];
                cnt++;
            }
            int diff = tempArr[chocolates - 1] - tempArr[0];
            if (diff < smallestDiff) {
                smallestDiff = diff;
            }
        }
        System.out.println("Min Difference is " + smallestDiff + ".");
    }
}