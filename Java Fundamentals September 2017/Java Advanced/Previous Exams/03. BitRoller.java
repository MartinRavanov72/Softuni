import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(scanner.readLine());
        int frozenPosition = Integer.parseInt(scanner.readLine());
        int times = Integer.parseInt(scanner.readLine());
        for (int i = 0; i < times; i++) {
            int firstBitValue = number & 1;
            int frozenBitValue = (number >> frozenPosition) & 1;
            int skipBitPos = frozenPosition != 18 ? frozenPosition + 1 : 0;
            int skipBitValue = (number >> skipBitPos) & 1;
            number = number >> 1;
            if (frozenPosition != 0) {
                number = number | firstBitValue << 18;
                number = number & ~(3 << frozenPosition - 1);
                number = number | frozenBitValue << frozenPosition;
                number = number | skipBitValue << frozenPosition - 1;
            }
            else {
                number = number & ~(1);
                number = number & ~(1 << 18);
                number = number | frozenBitValue;
                number = number | skipBitValue << 18;
            }
        }
        System.out.println(number);
    }
}