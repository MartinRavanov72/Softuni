package com.example.demo.services.product;

import com.example.demo.models.dtos.binding.product.ProductCreateBindingModel;
import com.example.demo.models.dtos.views.product.ProductInRangeViewModel;

import java.util.Collection;
import java.util.List;

public interface ProductService {

    void save(Collection<ProductCreateBindingModel> models);

    List<ProductInRangeViewModel> getAllByRangeWithoutBuyer(int from, int to);
}