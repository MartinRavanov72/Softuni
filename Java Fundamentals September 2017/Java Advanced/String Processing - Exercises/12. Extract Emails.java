import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(^| )[\\dA-Za-z]([\\w\\-\\.])*@[A-Za-z][A-Za-z\\-]*[A-Za-z](\\.[A-Za-z][A-Za-z\\-]*[A-Za-z])+(?=,| |.|$)");
        String line = scanner.nextLine();
        Matcher matcher = pattern.matcher(line);
        while(matcher.find()){
            System.out.println(matcher.group(0).trim());
        }
    }
}