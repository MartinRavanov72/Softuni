package spring_excr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring_excr.models.Product;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByPriceBetweenAndBuyerIdIsNullOrderByPrice(BigDecimal from, BigDecimal to);

    List<Product> findAll();

    Product findById(long id);
}
