package a_DefiningClassesEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String name = scanner.readLine();
        int age = Integer.parseInt(scanner.readLine());
        try {
            Chicken chicken = new Chicken(name, age);
            DecimalFormat df = new DecimalFormat("##.##");;
            System.out.printf("Chicken %s (age %d) can produce %s eggs per day.", chicken.getName(), chicken.getAge(), df.format(chicken.getProductivity()));
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
