import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;


public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] names = new String[n];
        int[] encryptedNames = new int[n];
        List<Character> vowels = new ArrayList<>();
        Collections.addAll(vowels, 'a', 'o', 'u', 'e', 'i', 'A', 'O', 'U', 'E', 'I');
        for (int i = 0; i < n; i++) {
            names[i] = scanner.nextLine();
            char[] nameByChars = names[i].toCharArray();
            int sum = 0;
            for (int j = 0; j < nameByChars.length; j++) {
                if (vowels.contains(nameByChars[j])) {
                    sum+= (int) nameByChars[j] * nameByChars.length;
                }
                else {
                    sum+= (int) nameByChars[j] / nameByChars.length;
                }
            }
            encryptedNames[i] = sum;
        }
        Arrays.sort(encryptedNames);
        for (int i = 0; i < encryptedNames.length; i++) {
            System.out.println(encryptedNames[i]);
        }
    }
}