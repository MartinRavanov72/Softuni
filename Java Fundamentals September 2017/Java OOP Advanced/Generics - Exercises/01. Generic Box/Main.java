package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(scanner.readLine());
        Box box = new Box<String>();
        for (int i = 0; i < n; i++) {
            String line = scanner.readLine();
            box.addToStorage(line);
        }
        System.out.println(box.toString());
    }
}