package a_DefiningClassesEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> cats = new HashSet<>();
        while (true){
            String input = scanner.readLine();
            if ("End".equals(input)){
                break;
            }
            cats.add(input);
        }
        String targetName = scanner.readLine();
        for (String cat : cats) {
            if (cat.contains(targetName)){
                String[] catParams = cat.split("\\s+");
                double catParam = Double.parseDouble(catParams[2]);
                for (int i = 0; i < catParams.length - 1; i++) {
                    System.out.print(catParams[i] + " ");
                }
                System.out.printf("%.2f", catParam);
                break;
            }
        }
    }
}
