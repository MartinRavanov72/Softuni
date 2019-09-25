package a_DefiningClassesEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] studentParams = scanner.readLine().split("\\s++");
            String[] workerParams = scanner.readLine().split("\\s++");
            Student student = new Student(studentParams[0], studentParams[1], studentParams[2]);
            Worker worker = new Worker(workerParams[0], workerParams[1], Integer.parseInt(workerParams[2]), Integer.parseInt(workerParams[3]));
            System.out.println(student.toString());
            System.out.println(worker.toString());
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}