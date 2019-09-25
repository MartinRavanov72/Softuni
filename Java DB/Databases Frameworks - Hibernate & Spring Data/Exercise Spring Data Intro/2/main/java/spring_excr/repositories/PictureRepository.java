package spring_excr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_excr.models.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
}
