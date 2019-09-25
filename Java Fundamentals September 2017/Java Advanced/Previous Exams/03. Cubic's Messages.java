import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String message = scanner.readLine();
            if ("Over!".equals(message)) {
                break;
            }
            int messageLength = Integer.parseInt(scanner.readLine());
            Pattern pattern = Pattern.compile("^(\\d+)([A-Za-z]{" + messageLength + "})([^A-Za-z]*)$");
            Matcher matcher = pattern.matcher(message);
            StringBuilder sb = new StringBuilder();
            if (matcher.matches() == false) {
                continue;
            }
            for (int i = 0; i < matcher.group(1).length(); i++) {
                if ((int)matcher.group(1).charAt(i) >= 48 && (int)matcher.group(1).charAt(i) <= 57) {
                    if (Integer.parseInt(matcher.group(1).charAt(i)+"") >= 0 && Integer.parseInt(matcher.group(1).charAt(i)+"") < matcher.group(2).length()) {
                        sb.append(matcher.group(2).charAt(Integer.parseInt(matcher.group(1).charAt(i)+"")));
                    }
                    else {
                        sb.append(" ");
                    }
                }
            }
            for (int i = 0; i < matcher.group(3).length(); i++) {
                if ((int)matcher.group(3).charAt(i) >= 48 && (int)matcher.group(3).charAt(i) <= 57) {
                    if (Integer.parseInt(matcher.group(3).charAt(i)+"") >= 0 && Integer.parseInt(matcher.group(3).charAt(i)+"") < matcher.group(2).length()) {
                        sb.append(matcher.group(2).charAt(Integer.parseInt(matcher.group(3).charAt(i)+"")));
                    }
                    else {
                        sb.append(" ");
                    }
                }
            }
            System.out.println(matcher.group(2) + " == " + sb.toString());
        }
    }
}