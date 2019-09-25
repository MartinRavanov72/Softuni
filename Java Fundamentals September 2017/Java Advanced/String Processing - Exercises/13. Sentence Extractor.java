import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\b[A-Z][^!.?]*?\\b" + word + "\\b[^!.?]*?[.!?]");
        Matcher matcher = pattern.matcher(scanner.nextLine());
        while(matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}