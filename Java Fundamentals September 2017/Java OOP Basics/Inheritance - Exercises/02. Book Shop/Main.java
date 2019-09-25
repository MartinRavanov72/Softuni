package a_DefiningClassesEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        try {
            String author = scanner.readLine();
            String title = scanner.readLine();
            double price = Double.parseDouble(scanner.readLine());
            Book book = new Book(author, title, price);
            GoldenEditionBook goldenEditionBook = new GoldenEditionBook(author, title, price);
            System.out.println(book.toString());
            System.out.println(goldenEditionBook.toString());
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }
}