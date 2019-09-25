package spring_excr.dtos;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;
import java.util.Set;

public class ProductDto {
    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    @Expose(serialize = false, deserialize = false)
    private UserDto buyer;

    @Expose(serialize = false, deserialize = false)
    private UserDto seller;

    @Expose(serialize = false, deserialize = false)
    private Set<CategoryDto> categories;

    public ProductDto() {

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

    public UserDto getBuyer() {
        return buyer;
    }

    public void setBuyer(UserDto buyer) {
        this.buyer = buyer;
    }

    public UserDto getSeller() {
        return seller;
    }

    public void setSeller(UserDto seller) {
        this.seller = seller;
    }

    public Set<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryDto> cateories) {
        this.categories = cateories;
    }
}
