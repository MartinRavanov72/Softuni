import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("[\\s,\\.\\?\\!]");
        Set<String> result = new TreeSet<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder reverser = new StringBuilder();
            for (int j = words[i].length() - 1; j >= 0; j--)
            {
                reverser.append(words[i].charAt(j));
            }
            boolean s = reverser.toString().equals(words[i]);
            if (s && !words[i].equals("")){
                result.add(words[i]);
            }
        }

        Iterator<String> it = result.iterator();
        String[] arr = new String[result.size()];
        int i = 0;
        while (it.hasNext()) {
            arr[i] = it.next();
            i++;
        }

        System.out.println(Arrays.toString(arr));
    }
}