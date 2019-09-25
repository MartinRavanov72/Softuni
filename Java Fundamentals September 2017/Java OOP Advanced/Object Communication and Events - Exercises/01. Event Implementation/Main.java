package b_secondPrinciple;

import b_secondPrinciple.models.Dispatcher;
import b_secondPrinciple.models.Handler;
import b_secondPrinciple.models.NameChangeListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        Dispatcher dispatcher = new Dispatcher();
        NameChangeListener nameChangeListener = new Handler();
        dispatcher.addNameChangeListener(nameChangeListener);
        while (true) {
            String input = scanner.readLine();
            if (input.equals("End")){
                break;
            }
            dispatcher.setName(input);
        }
    }
}