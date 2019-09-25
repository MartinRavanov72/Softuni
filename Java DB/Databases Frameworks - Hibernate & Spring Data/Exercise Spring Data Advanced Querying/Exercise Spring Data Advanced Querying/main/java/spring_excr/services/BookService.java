package spring_excr.services;

import spring_excr.models.Book;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface BookService {
    void saveBookIntoDb(Book book);

    void saveBookIntoDb(List<Book> books);

    List<Book> findAllByAgeRestrictionIgnoreCase(String ageRestriction);

    List<Book> findAllByEditionTypeIgnoreCaseAndCopiesLessThan(String ageRestriction, int copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lowest, BigDecimal highest);

    List<Book> findAllByReleaseDateNot(int year);

    List<Book> findAllByReleaseDateBefore(Date date);

    List<Book> findAllByTitleContainingIgnoreCase(String str);

    List<Book> findAllByAuthorIdLastNameIgnoreCaseStartingWith(String ending);

    List<Book> findAllByTitleLengthGreaterThan(long length);

    List<Book> findAllByTitle(String title);

    int increaseCopiesWithAfterDate( int copiesQuantity, Date afterDate);

    int deleteBookCopiesLessThan(int copiesQuantity);

    int findAllTitlesByProcedure(String firstName, String lastName);

}
