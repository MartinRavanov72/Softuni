package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        Object[] strings = ArrayCreator.create(3, "azis");
        Integer[] integers = ArrayCreator.create(Integer.class, 8, 2);
        System.out.println(integers.length);
    }
}