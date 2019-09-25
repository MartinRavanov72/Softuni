package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = scanner.readLine().split("\\s+");
        Tuple<String, String> tuple1 = new Tuple<>(line1[0] + " " + line1[1], line1[2]);
        String[] line2 = scanner.readLine().split("\\s+");
        Tuple<String, Integer> tuple2 = new Tuple<>(line2[0], Integer.parseInt(line2[1]));
        String[] line3 = scanner.readLine().split("\\s+");
        Tuple<Integer, Double> tuple3 = new Tuple<>(Integer.parseInt(line3[0]), Double.parseDouble(line3[1]));
        System.out.println(tuple1.toString());
        System.out.println(tuple2.toString());
        System.out.println(tuple3.toString());
    }
}