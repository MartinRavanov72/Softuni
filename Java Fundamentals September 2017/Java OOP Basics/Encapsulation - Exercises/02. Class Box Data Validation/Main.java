package a_DefiningClassesEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        double length = Double.parseDouble(scanner.readLine());
        double width = Double.parseDouble(scanner.readLine());
        double height = Double.parseDouble(scanner.readLine());
        try {
            Box box = new Box(length, width, height);
            System.out.printf("Surface Area - %.2f%n", box.getSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f%n", box.getLateralSurfaceArea());
            System.out.printf("Volume - %.2f%n", box.getVolume());
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
