package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        MyList list = new MyList();
        int n = Integer.parseInt(scanner.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.readLine().split("\\s+");
            if (input[0].equals("Add")) {
                list.add(Integer.parseInt(input[1]));
            } else {
                list.remove(Integer.parseInt(input[1]));
            }
        }
        System.out.println(list.getSize());
        System.out.println(list.toString().replaceAll("[\\[\\],]",""));
    }
}