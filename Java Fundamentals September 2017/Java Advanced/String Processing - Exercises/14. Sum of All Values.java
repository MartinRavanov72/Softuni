import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String keysString = scanner.nextLine();
        String textString = scanner.nextLine();
        Pattern patternStartKey = Pattern.compile("^[A-Za-z_]+(?=[0-9])");
        Pattern patternEndKey = Pattern.compile("(?<=[0-9])[A-Za-z_]+$");
        Matcher matcherStartKey = patternStartKey.matcher(keysString);
        Matcher matcherEndKey = patternEndKey.matcher(keysString);
        String startKey = "";
        String endKey = "";
        if (matcherStartKey.find() && matcherEndKey.find()){
            startKey = matcherStartKey.group(0);
            endKey = matcherEndKey.group(0);
            Pattern pattern = Pattern.compile(startKey + "[0-9.]+?" + endKey);
            Matcher matcher = pattern.matcher(textString);
            double result = 0;
            while (matcher.find()){
                try {
                    double num = Double.parseDouble(matcher.group(0).substring(startKey.length(), matcher.group(0).length() - endKey.length()));
                    result += num;
                }
                catch (Exception e){

                }
            }
            DecimalFormat df = new DecimalFormat("#.##");
            if (result > 0) {
                System.out.printf("<p>The total value is: <em>%s</em></p>", df.format(result));
                System.out.println();
            }
            else {
                System.out.println("<p>The total value is: <em>nothing</em></p>");
            }
        }
        else {
            System.out.println("<p>A key is missing</p>");
        }
    }
}