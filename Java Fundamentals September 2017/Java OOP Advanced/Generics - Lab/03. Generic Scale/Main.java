package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        Scale<String> scale = new Scale<>("Azis", "SashoRomana");
        System.out.println(scale.getHeavier());
    }
}