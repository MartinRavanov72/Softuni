import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private String name;
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(this.books);
    }
}