package spring_excr.services;

import spring_excr.models.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void add(Product product);

    List<Product> findByPriceBetweenAndBuyerIdIsNullOrderByPrice(int from, int to);

    List<Product> getAll();

    Product findById(int id);
}