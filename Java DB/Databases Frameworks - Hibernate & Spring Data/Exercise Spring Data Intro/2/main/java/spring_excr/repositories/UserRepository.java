package spring_excr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_excr.models.User;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByEmailEndingWith(String end);

    List<User> findAllByLastTimeLoggedInBefore(LocalDateTime dateTime);
}
