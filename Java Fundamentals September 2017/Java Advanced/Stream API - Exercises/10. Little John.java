import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int small = 0;
        int medium = 0;
        int large = 0;
        Pattern pattern = Pattern.compile("(?<small>>----->)|(?<medium>>>----->)|(?<large>>>>----->>)");
        for(int i = 0 ;i < 4; i++){
            String input = scanner.readLine();
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()){
                if (matcher.group("small") != null){
                    small++;
                }
                else if(matcher.group("medium") != null){
                    medium++;
                }
                else{
                    large++;
                }
            }
        }
        String sum = small + "" + medium + "" + large;
        String binary = Integer.toBinaryString(Integer.valueOf(sum));
        String reversedBinary = new StringBuilder(Integer.toBinaryString(Integer.valueOf(sum)) + "").reverse() + "";
        System.out.println(Integer.valueOf(binary + reversedBinary, 2));
    }
}