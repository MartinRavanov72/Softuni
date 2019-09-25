package spring_excr.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring_excr.models.Author;

import java.util.Date;
import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer>{
    @Query(value = "select a.first_name, a.last_name, sum(b.copies) " +
            "from authors as a " +
            "join books as b " +
            "on a.id = b.author_id " +
            "group by a.id " +
            "order by sum(b.copies) desc", nativeQuery = true)
    List<Object[]> findAllByOrderByBooksDesc();

    List<Author> findAllByFirstNameEndingWith(String ending);
}
