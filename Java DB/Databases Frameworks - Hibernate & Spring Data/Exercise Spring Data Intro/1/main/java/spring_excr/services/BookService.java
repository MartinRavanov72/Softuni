package spring_excr.services;

import spring_excr.models.Book;

import java.time.Year;
import java.util.Date;
import java.util.List;

public interface BookService {
    void saveBookIntoDb(Book book);

    void saveBookIntoDb(List<Book> books);

    List<String> allTitlesAfterYear(Date year);

    List<Book> findBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateAndTitle(String firstName, String secondName);

}
