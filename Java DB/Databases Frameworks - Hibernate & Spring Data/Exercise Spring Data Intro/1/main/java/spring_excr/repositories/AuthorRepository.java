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
    @Query(value = "SELECT a.first_name, a.last_name, count(b.id) AS count\n" +
            "        FROM authors AS a\n" +
            "          INNER JOIN books AS b\n" +
            "            ON a.id = b.author_id\n" +
            "        GROUP BY a.id, a.first_name, a.last_name\n" +
            "ORDER BY count DESC;", nativeQuery = true)
    List<Object[]> findAuthorsByOrOrderByBooksDesc();

    @Query(value = "SELECT authors.id, authors.first_name, authors.last_name\n" +
            "  FROM (SELECT a.id, a.first_name, a.last_name, count(b.id) AS count\n" +
            "        FROM authors AS a\n" +
            "          INNER JOIN books AS b\n" +
            "            ON a.id = b.author_id\n" +
            "           AND year(b.release_date) < :currentYear\n" +
            "        GROUP BY a.id, a.first_name, a.last_name\n" +
            "       HAVING count(b.id) > 0) AS authors\n" +
            "ORDER BY authors.count DESC;\n", nativeQuery = true)
    List<Author> findAuthorsByBooksReleaseDateBeforeYear(@Param("currentYear") Date year);
}
