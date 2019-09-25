package a_DefiningClassesEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] lineParams = scanner.readLine().split(" ");
//            String[] secondLineParams = {""};
//            if ("Dough".equalsIgnoreCase(lineParams[0])) {
//                String[] doughParams = new String[2];
//                int cnt = 0;
//                for (int i = lineParams.length - 2; i >= 1; i--) {
//                    doughParams[cnt] = lineParams[i].toLowerCase();
//                    cnt++;
//                }
//                Dough dough = new Dough(doughParams, Double.parseDouble(lineParams[lineParams.length - 1]));
//                System.out.printf("%.2f\n", dough.getCalories());
//                secondLineParams = scanner.readLine().toLowerCase().split(" ");
//            }
//            if ("END".equalsIgnoreCase(secondLineParams[0])) {
//                return;
//            } else if ("Topping".equalsIgnoreCase(secondLineParams[0])) {
//                Topping topping = new Topping(secondLineParams[1], Double.parseDouble(secondLineParams[2]));
//                System.out.printf("%.2f\n", topping.getCalories());
//                return;
//            }
            Pizza pizza = new Pizza(lineParams[1]);
            int n = Integer.parseInt(lineParams[2]);
            if (n < 1 || n > 10) {
                throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
            }
            lineParams = scanner.readLine().split(" ");
            String[] doughParams = new String[2];
            int cnt = 0;
            for (int i = lineParams.length - 2; i >= 1; i--) {
                doughParams[cnt] = lineParams[i];
                cnt++;
            }
            Dough dough = new Dough(doughParams, Double.parseDouble(lineParams[lineParams.length - 1]));
            pizza.setDough(dough);
            while (true) {
                lineParams = scanner.readLine().split(" ");
                if (lineParams[0].equals("END")) {
                    break;
                }
                Topping topping = new Topping(lineParams[1], Double.parseDouble(lineParams[2]));
                pizza.addTopping(topping);
            }
            System.out.println(pizza.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}