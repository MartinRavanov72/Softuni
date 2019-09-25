package com.example.demo.services.product;

import com.example.demo.models.dtos.binding.product.ProductCreateBindingModel;
import com.example.demo.models.dtos.views.product.ProductInRangeViewModel;
import com.example.demo.models.entity.Product;
import com.example.demo.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	private final ModelMapper mapper;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository,
							  ModelMapper mapper) {
		this.productRepository = productRepository;
		this.mapper = mapper;
	}

	@Override
	public void save(Collection<ProductCreateBindingModel> models) {
		List<Product> products = models.stream().map(m -> this.mapper.map(m,Product.class)).collect(Collectors.toList());
		this.productRepository.save(products);
	}

    @Override
    public List<ProductInRangeViewModel> getAllByRangeWithoutBuyer(int from, int to) {
        return this.productRepository.getAllByRangeWithoutBuyer(new BigDecimal(from),new BigDecimal(to));
    }
}