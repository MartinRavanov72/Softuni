import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String sentence = scanner.readLine();
        while(true){
            String command = scanner.readLine();
            if ("Print".equals(command)) {
                break;
            }
            if (command.contains("%")) {
                command = command.replace("%", "[^ ]*");
                command = command.replace( ".", "\\.");
                Pattern pattern = Pattern.compile(command);
                Matcher matcher = pattern.matcher(sentence);
                while (matcher.find()) {
                    StringBuilder sb = new StringBuilder(matcher.group(0));
                    sentence = sentence.replace(matcher.group(0), sb.reverse().toString());
                }
            }
            else {
                if (sentence.contains(command)) {
                    int index = sentence.indexOf(command);
                    while(index > -1) {
                        StringBuilder substr = new StringBuilder(sentence.substring(index, index + command.length()));
                        substr.reverse();
                        sentence = sentence.replace(sentence.substring(index, index + command.length()), substr.toString());
                        index = sentence.indexOf(command, index);
                    }
                }
            }
        }
        System.out.println(sentence);
    }
}