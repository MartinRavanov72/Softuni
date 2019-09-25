package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        MyStack stack = new MyStack();
        while(true) {
            String[] input = scanner.readLine().split("\\s+");
            if (input[0].equals("END")) {
                break;
            }
            switch (input[0]) {
                case "Push":
                    for (int i = 1; i < input.length; i++) {
                        stack.push(Integer.parseInt(input[i].replace(",","")));
                    }
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    } catch (IndexOutOfBoundsException iobe) {
                        System.out.println("No elements");
                    }
                    break;
            }
        }
        for (int i = 0; i < 2; i++) {
            stack.forEach(System.out::println);
        }
    }
}