package spring_excr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_excr.models.Town;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {
}
