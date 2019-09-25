package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(scanner.readLine());
        Box<Double> box = new Box();
        List<Double> list  = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.readLine();
            list.add(Double.parseDouble(line));
        }
        Double element = Double.parseDouble(scanner.readLine());
        int cnt = box.count(list, element);
        System.out.println(cnt);
    }
}