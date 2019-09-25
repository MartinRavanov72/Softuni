package spring_excr.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring_excr.models.Book;

import java.math.BigDecimal;
import java.time.Year;
import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{

    List<Book> findAllByAgeRestrictionIgnoreCase(String ageRestriction);

    List<Book> findAllByEditionTypeIgnoreCaseAndCopiesLessThan(String ageRestriction, int copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lowest, BigDecimal highest);

    @Query(value = "select b from Book as b where year(b.releaseDate) != :searchedDate")
    List<Book> findAllByReleaseDateNot(@Param(value = "searchedDate") int year);

    List<Book> findAllByReleaseDateBefore(Date date);

    List<Book> findAllByTitleContainingIgnoreCase(String str);

    List<Book> findAllByAuthorIdLastNameIgnoreCaseStartingWith(String ending);

    @Query(value = "select b from Book as b where char_length(b.title) > :titleLength")
    List<Book> findAllByTitleLengthGreaterThan(@Param(value = "titleLength") long length);

    List<Book> findAllByTitle(String title);

    @Modifying
    @Query(value = "update Book as b set b.copies = b.copies + :copiesQuantity where b.releaseDate > :afterDate")
    int increaseCopiesWithAfterDate(@Param(value = "copiesQuantity") int copiesQuantity, @Param(value = "afterDate") Date afterDate);

    @Modifying
    @Query(value = "delete from Book as b where b.copies < :copiesQuantity")
    int deleteBookCopiesLessThan(@Param(value = "copiesQuantity") int copiesQuantity);

    @Query(value = "call usp_find_number_of_titles_by_author_name(:firstName, :lastName)", nativeQuery = true)
    int findAllTitlesByProcedure(@Param(value = "firstName") String firstName, @Param(value = "lastName") String lastName);

}
