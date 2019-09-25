package spring_excr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_excr.models.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
