package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = scanner.readLine().split("\\s+");
        Tuple<String, String, String> tuple1 = new Tuple<>(line1[0] + " " + line1[1], line1[2], line1[3]);
        String[] line2 = scanner.readLine().split("\\s+");
        Tuple<String, Integer, Boolean> tuple2 = new Tuple<>(line2[0], Integer.parseInt(line2[1]), line2[2].equals("drunk"));
        String[] line3 = scanner.readLine().split("\\s+");
        Tuple<String, Double, String> tuple3 = new Tuple<>(line3[0], Double.parseDouble(line3[1]), line3[2]);
        System.out.println(tuple1.toString());
        System.out.println(tuple2.toString());
        System.out.println(tuple3.toString());
    }
}