package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        ListyIterator iterator = new ListyIterator();
        while (true) {
            String[] input = scanner.readLine().split("\\s+");
            if (input[0].equals("END")) {
                break;
            }
            switch (input[0]) {
                case "Create":
                    String[] result = new String[input.length - 1];
                    for (int i = 1; i < input.length; i++) {
                        result[i - 1] = input[i];
                    }
                    iterator = new ListyIterator(result);
                    break;
                case "Move":
                    System.out.println(iterator.move());
                    break;
                case "Print":
                    System.out.println(iterator.print());
                    break;
                case "HasNext":
                    System.out.println(iterator.hasNext());
                    break;
            }
        }
    }
}