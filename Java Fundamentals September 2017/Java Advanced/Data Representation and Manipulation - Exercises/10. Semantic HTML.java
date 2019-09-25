import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern openTagPattern = Pattern.compile("(?<replace><div).+(?<remove>(id|class) *?= *?\"(?<newName>\\w+)\").+>?");
        Pattern closeTagPattern = Pattern.compile("<\\/div>[\\s]*(?<delete><!--[\\s]*?(?<word>\\w+)[\\s]*?-->)");
        String[] validTags = {"main", "header", "nav", "article", "section", "aside", "footer"};
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("END")) {
                break;
            }
            Matcher openTagMatcher = openTagPattern.matcher(input);
            Matcher closeTagMatcher = closeTagPattern.matcher(input);
            if (openTagMatcher.find() && Arrays.asList(validTags).contains(openTagMatcher.group("newName"))) {
                String result = openTagMatcher.group().replace(openTagMatcher.group("replace"), "<" + openTagMatcher.group("newName")).replace(openTagMatcher.group("remove"), "");
                System.out.println(result.replaceAll(" +>",">").replaceAll(" +"," "));
            } 
            else if (closeTagMatcher.find() && Arrays.asList(validTags).contains(closeTagMatcher.group("word"))){
                String result = closeTagMatcher.group().replace("div", closeTagMatcher.group("word")).replace(closeTagMatcher.group("delete"),"");
                System.out.println(result.replaceAll(" +",""));
            } 
            else {
                System.out.println(input);
            }
        }
    }
}
