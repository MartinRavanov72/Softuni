package com.example.demo.utils.config;

import com.example.demo.models.dtos.binding.product.ProductCreateBindingModel;
import com.example.demo.models.entity.Product;
import com.example.demo.repositories.UserRepository;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperConfig {

    private final ModelMapper mapper;

    private final UserRepository userRepository;

    public ModelMapperConfig(ModelMapper mapper,
                             UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.init();
    }

    private void init() {
        this.productCreateBindingConfiguration();
    }

    private void productCreateBindingConfiguration() {
        Converter<ProductCreateBindingModel, Product> con = new AbstractConverter<ProductCreateBindingModel, Product>() {
            @Override
            protected Product convert(ProductCreateBindingModel src) {
                Product p = new Product();
                Integer buyer = src.getBuyer();
                if (buyer != null) {
                    p.setBuyer(userRepository.findOne(buyer));
                }
                p.setSeller(userRepository.findOne(src.getSeller()));
                p.setName(src.getName());
                p.setPrice(src.getPrice());
                return p;
            }
        };
        this.mapper.addConverter(con);
    }
}
