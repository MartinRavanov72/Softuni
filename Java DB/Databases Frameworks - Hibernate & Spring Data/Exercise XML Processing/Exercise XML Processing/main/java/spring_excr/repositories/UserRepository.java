package spring_excr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring_excr.models.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User AS u " +
            "JOIN u.productsForSelling AS p " +
            "WHERE p.buyer IS NOT NULL " +
            "GROUP BY u.id")
    List<User> findAllUsersWithSolldProducts();

    List<User> findAll();

    User findById(long id);
}
