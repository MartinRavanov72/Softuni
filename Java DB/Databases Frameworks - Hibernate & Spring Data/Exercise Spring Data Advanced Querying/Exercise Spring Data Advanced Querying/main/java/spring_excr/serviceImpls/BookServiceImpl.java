package spring_excr.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring_excr.models.Book;
import spring_excr.repositories.BookRepository;
import spring_excr.services.BookService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void saveBookIntoDb(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public void saveBookIntoDb(List<Book> books) {
        this.bookRepository.save(books);
    }

    @Override
    public List<Book> findAllByAgeRestrictionIgnoreCase(String ageRestriction) {
        return this.bookRepository.findAllByAgeRestrictionIgnoreCase(ageRestriction);
    }

    @Override
    public List<Book> findAllByEditionTypeIgnoreCaseAndCopiesLessThan(String ageRestriction, int copies) {
        return this.bookRepository.findAllByEditionTypeIgnoreCaseAndCopiesLessThan(ageRestriction, copies);
    }

    @Override
    public List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lowest, BigDecimal highest) {
        return this.bookRepository.findAllByPriceLessThanOrPriceGreaterThan(lowest, highest);
    }

    @Override
    public List<Book> findAllByReleaseDateNot(int year) {
        return this.bookRepository.findAllByReleaseDateNot(year);
    }

    @Override
    public List<Book> findAllByReleaseDateBefore(Date date) {
        return this.bookRepository.findAllByReleaseDateBefore(date);
    }

    @Override
    public List<Book> findAllByTitleContainingIgnoreCase(String str) {
        return this.bookRepository.findAllByTitleContainingIgnoreCase(str);
    }

    @Override
    public List<Book> findAllByAuthorIdLastNameIgnoreCaseStartingWith(String ending) {
        return this.bookRepository.findAllByAuthorIdLastNameIgnoreCaseStartingWith(ending);
    }

    @Override
    public List<Book> findAllByTitleLengthGreaterThan(long length) {
        return this.bookRepository.findAllByTitleLengthGreaterThan(length);
    }

    @Override
    public List<Book> findAllByTitle(String title) {
        return this.bookRepository.findAllByTitle(title);
    }

    @Override
    public int increaseCopiesWithAfterDate(int copiesQuantity, Date afterDate) {
        return this.bookRepository.increaseCopiesWithAfterDate(copiesQuantity, afterDate);
    }

    @Override
    public int deleteBookCopiesLessThan(int copiesQuantity) {
        return this.bookRepository.deleteBookCopiesLessThan(copiesQuantity);
    }

    @Override
    public int findAllTitlesByProcedure(String firstName, String lastName) {
        return this.bookRepository.findAllTitlesByProcedure(firstName, lastName);
    }

}
