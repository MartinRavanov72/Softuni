package spring_excr.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring_excr.models.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{
}
