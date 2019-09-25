import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("<a href=\\\".+\\\">([\\s\\S]+?<\\/a>)?");
        StringBuilder sb = new StringBuilder();
        String line = scanner.nextLine();
        while (!line.equals("END")){
            sb.append(line + "\n");
            line = scanner.nextLine();
        }
        String input = sb.toString();
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            String replacement = matcher.group(0).replace("<a","[URL").replace("</a>","[/URL]").replace(">","]");
            input = input.replace(matcher.group(0), replacement);
        }
        System.out.println(input);
    }
}