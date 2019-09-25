import java.util.*;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class DVS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(?<=[ \\/\\\\()]|^)[a-zA-Z]\\w{2,25}(?=[ \\/\\\\()]|$)");
        Matcher matcher = pattern.matcher(scanner.nextLine());
        LinkedList<String> usernames = new LinkedList<>();
        while(matcher.find()){
            usernames.add(matcher.group(0));
        }
        int startIndex = 0;
        int endIndex = 0;
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < usernames.size() - 1; i++) {
            int currentLength = usernames.get(i).length() + usernames.get(i+1).length();
            if (currentLength > maxLength){
                startIndex = i;
                endIndex = i + 1;
                maxLength = currentLength;
            }
        }
        System.out.println(usernames.get(startIndex));
        System.out.println(usernames.get(endIndex));
    }
}