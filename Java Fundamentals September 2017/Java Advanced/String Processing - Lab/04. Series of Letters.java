import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] chArr = line.toCharArray();
        int state = 0;
        char previousChar = chArr[0];
        StringBuilder output = new StringBuilder();
        for (int i = 0; i <= chArr.length; i++) {
            if (i == chArr.length) {
                if (!(chArr[i - 1] == chArr[i - 2])) {
                    output.append(chArr[i - 1]);
                }
            }
            else {
                switch (state) {
                    case 0:
                        state = 1;
                        previousChar = chArr[i];
                        break;
                    case 1:
                        output.append(previousChar);
                        if (chArr[i] == previousChar) {
                            state = 2;
                        }
                        previousChar = chArr[i];
                        break;
                    case 2:
                        if (chArr[i] != previousChar){
                            state = 1;
                        }
                        previousChar = chArr[i];
                        break;
                }
            }
        }
        System.out.println(output);
    }
}