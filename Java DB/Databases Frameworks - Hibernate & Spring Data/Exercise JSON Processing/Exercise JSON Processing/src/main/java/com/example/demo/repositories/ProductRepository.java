package com.example.demo.repositories;

import com.example.demo.models.dtos.views.product.ProductInRangeViewModel;
import com.example.demo.models.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("SELECT new com.example.demo.models.dtos.views.product.ProductInRangeViewModel(" +
            "p.name,p.price, TRIM(CONCAT(COALESCE(p.seller.firstName,'') ,' ',p.seller.lastName)) )" +
            " FROM Product AS p WHERE (p.price BETWEEN :from AND :to) AND " +
            "p.buyer IS NULL " +
            "ORDER BY p.price ASC")
    List<ProductInRangeViewModel> getAllByRangeWithoutBuyer(@Param("from") BigDecimal from, @Param("to") BigDecimal to);
}