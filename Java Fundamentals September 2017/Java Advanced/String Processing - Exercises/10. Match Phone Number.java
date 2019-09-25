import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^\\+359([ \\-])2\\1\\d{3}\\1\\d{4}$");
        String line = scanner.nextLine();
        while(!line.equals("end")){
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                System.out.println(line);
            }
            line = scanner.nextLine();
        }
    }
}