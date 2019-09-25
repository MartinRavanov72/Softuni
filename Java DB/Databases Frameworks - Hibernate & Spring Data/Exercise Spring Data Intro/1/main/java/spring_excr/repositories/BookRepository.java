package spring_excr.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring_excr.models.Book;

import java.time.Year;
import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{
    List<Book> findAllByReleaseDateAfter(Date year);

    List<Book> findBooksByAuthorIdFirstNameAndAuthorIdLastNameOrderByReleaseDateDescTitleAsc(String authorFirstName, String authorLastName);
}
