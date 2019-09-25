package com.example.demo.models.dtos.views.product;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductInRangeViewModel implements Serializable {

    private String name;
    private BigDecimal price;
    private String seller;

    public ProductInRangeViewModel(String name, BigDecimal price, String seller) {
        this.name = name;
        this.price = price;
        this.seller = seller;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSeller() {
        return this.seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
