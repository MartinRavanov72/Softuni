package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        while (true) {
            String[] input = scanner.readLine().split("\\s+");
            if (input[0].equals("END")) {
                break;
            }
            try {
                coffeeMachine.insertCoin(input[0]);
            } catch (IllegalArgumentException e) {
                coffeeMachine.buyCoffee(input[0], input[1]);
            }
        }
        for (Coffee coffee : coffeeMachine.coffeesSold()) {
            System.out.println(coffee);
        }
    }
}