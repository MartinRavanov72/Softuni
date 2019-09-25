package a_DefiningClassesEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        Box box = new Box();
        box.setLength(Double.parseDouble(scanner.readLine()));
        box.setWidth(Double.parseDouble(scanner.readLine()));
        box.setHeight(Double.parseDouble(scanner.readLine()));
        System.out.printf("Surface Area - %.2f", box.getSurfaceArea());
        System.out.println();
        System.out.printf("Lateral Surface Area - %.2f", box.getLateralSurfaceArea());
        System.out.println();
        System.out.printf("Volume - %.2f", box.getVolume());
        System.out.println();
    }
}
