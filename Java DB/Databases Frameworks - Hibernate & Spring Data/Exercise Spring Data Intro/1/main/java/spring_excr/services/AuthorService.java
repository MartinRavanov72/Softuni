package spring_excr.services;

import spring_excr.models.Author;

import java.util.Date;
import java.util.List;

public interface AuthorService {
    void saveAuthorIntoDb(Author author);

    void saveAuthorIntoDb(List<Author> authors);

    List<Object[]> findAllByOrderByBooksDesc();

    List<Author> findAuthorsByBooksReleaseDateBeforeYear(Date year);
}
