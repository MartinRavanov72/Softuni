package a_DefiningClassesEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        Wizard gandalf = new Wizard();
        String[] foodParams = scanner.readLine().split("\\s+");
        gandalf.eat(foodParams);
        System.out.println(gandalf.toString());
    }
}