import java.util.*;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] lineParams = scanner.nextLine().split(", ");
        int[] arr = new int[lineParams.length];
        for (int i = 0; i < lineParams.length; i++) {
            arr[i] = Integer.parseInt(lineParams[i]);
        }
        Arrays.sort(arr);
        boolean isLastNum = true;
        for (int i = 0; i < lineParams.length; i++) {
            if (!(arr[i] == i + 1)) {
                System.out.println(i + 1);
                isLastNum = false;
                break;
            }
        }
        if (isLastNum) {
            System.out.println(n);
        }
    }
}