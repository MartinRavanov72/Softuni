package b_secondPrinciple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        PrimitiveCalculator calculator = PrimitiveCalculator.getInstance();
        while (true) {
            String[] inputParams = scanner.readLine().split("\\s+");
            if (inputParams[0].equalsIgnoreCase("end")) {
                break;
            }
            else if (inputParams[0].equalsIgnoreCase("mode")) {
                calculator.changeStrategy(getStrategy(inputParams[1].charAt(0)));
            } else {
                System.out.println(calculator.performCalculation(Integer.parseInt(inputParams[0]), Integer.parseInt(inputParams[1])));
            }
        }
    }

    private static Strategy getStrategy(char ch) {
        switch (ch) {
            case '*' :
                return MultiplicationStrategy.getInstance();
            case '/' :
                return DivisionStrategy.getInstance();
            case '+' :
                return AdditionStrategy.getInstance();
            case '-' :
                return SubtractionStrategy.getInstance();
            default:
                return null;
        }
    }
}
