package spring_excr.dtos;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class UserDto {
    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private Integer age;

    @Expose(serialize = false, deserialize = false)
    private Set<UserDto> friends;

    @Expose(serialize = false, deserialize = false)
    private Set<ProductDto> productsForBuying;

    @Expose(serialize = false, deserialize = false)
    private Set<ProductDto> productsForSelling;

    public UserDto() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<UserDto> getFriends() {
        return friends;
    }

    public void setFriends(Set<UserDto> friends) {
        this.friends = friends;
    }

    public Set<ProductDto> getProductsForBuying() {
        return productsForBuying;
    }

    public void setProductsForBuying(Set<ProductDto> productsForBuying) {
        this.productsForBuying = productsForBuying;
    }

    public Set<ProductDto> getProductsForSelling() {
        return productsForSelling;
    }

    public void setProductsForSelling(Set<ProductDto> productsForSelling) {
        this.productsForSelling = productsForSelling;
    }
}
