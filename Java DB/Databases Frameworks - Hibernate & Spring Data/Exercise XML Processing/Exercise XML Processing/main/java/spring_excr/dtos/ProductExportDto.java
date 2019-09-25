package spring_excr.dtos;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ProductExportDto {

    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    @Expose
    private String seller;

    public ProductExportDto(String name, BigDecimal price, String seller) {
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

