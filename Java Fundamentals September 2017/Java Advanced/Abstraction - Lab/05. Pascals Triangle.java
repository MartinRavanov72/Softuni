import java.lang.reflect.Array;
        import java.math.BigDecimal;
        import java.math.BigInteger;
        import java.text.DecimalFormat;
        import java.util.*;


public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        long[][] tringle = new long[height][height];
        for (int currentHeight = 0; currentHeight < height; currentHeight++) {
            tringle[currentHeight][0] = 1;
            tringle[currentHeight][currentHeight] = 1;
            if (currentHeight > 1){
                for (int j = 1; j < currentHeight; j++){
                    long[] previousRow = tringle[currentHeight - 1];
                    long previousRowSum = previousRow[j] + previousRow[j - 1];
                    tringle[currentHeight][j] = previousRowSum;
                }
            }
        }
        for (int i = 0; i < tringle.length; i++) {
            for (int j = 0; j < tringle[i].length; j++) {
                if (tringle[i][j] != 0) {
                    System.out.print(tringle[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
