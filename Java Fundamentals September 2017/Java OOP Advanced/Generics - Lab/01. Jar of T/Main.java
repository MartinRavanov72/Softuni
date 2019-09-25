package interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        Jar<Pickle> jarOfPickles = new Jar<>();
        jarOfPickles.add(new Pickle());
        jarOfPickles.add(new Pickle());
        Pickle pickle = jarOfPickles.remove();
    }
}