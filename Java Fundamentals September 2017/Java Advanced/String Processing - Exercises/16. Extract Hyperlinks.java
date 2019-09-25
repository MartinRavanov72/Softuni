import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("<a\\s+([^>]+\\s+)?href\\s*=\\s*('([^']*)'|\"([^\\\"]*)|([^\\s>]+))[^>]*>");
        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        while (!input.equals("END")){
            sb.append(input);
            input = scanner.nextLine();
        }
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()){
            for (int i = 5; i >= 1; i--) {
                if (matcher.group(i) != null){
                    System.out.println(matcher.group(i));
                    break;
                }
            }
        }
    }
}