package spring_excr.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring_excr.models.Product;
import spring_excr.repositories.ProductRepository;
import spring_excr.services.ProductService;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void add(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public List<Product> findByPriceBetweenAndBuyerIdIsNullOrderByPrice(int from, int to) {
        return this.productRepository.findByPriceBetweenAndBuyerIdIsNullOrderByPrice(new BigDecimal(from),new BigDecimal(to));
    }

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return this.productRepository.findById(id);
    }
}
