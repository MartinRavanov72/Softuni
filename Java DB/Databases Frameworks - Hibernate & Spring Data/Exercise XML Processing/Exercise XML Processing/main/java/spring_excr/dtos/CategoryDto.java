package spring_excr.dtos;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class CategoryDto {
    @Expose
    private String name;

    @Expose(serialize = false, deserialize = false)
    private Set<ProductDto> products;

    public CategoryDto() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductDto> products) {
        this.products = products;
    }
}
