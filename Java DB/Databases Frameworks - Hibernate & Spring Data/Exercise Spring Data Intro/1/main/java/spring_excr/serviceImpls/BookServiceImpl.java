package spring_excr.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring_excr.models.Book;
import spring_excr.repositories.BookRepository;
import spring_excr.services.BookService;

import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<String> allTitlesAfterYear(Date year) {
        return this.bookRepository.findAllByReleaseDateAfter(year).stream().map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<Book> findBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateAndTitle(String firstName, String secondName) {
        return this.bookRepository.findBooksByAuthorIdFirstNameAndAuthorIdLastNameOrderByReleaseDateDescTitleAsc(firstName, secondName);
    }
}
