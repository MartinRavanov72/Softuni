import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bannedWords = scanner.nextLine().split(, );
        String line = scanner.nextLine();
        for (int i = 0; i  bannedWords.length; i++) {
            line = line.replace(bannedWords[i], new String(new char[bannedWords[i].length()]).replace(0, ));
        }
        System.out.println(line);
    }
}