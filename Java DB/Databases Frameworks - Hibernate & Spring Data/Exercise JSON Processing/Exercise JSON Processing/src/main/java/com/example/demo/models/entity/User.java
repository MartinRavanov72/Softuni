package com.example.demo.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Set<User> friends;
    private Set<Product> productsForBuying;
    private Set<Product> productsForSelling;

    public User() {
        this.friends = new HashSet<>();
        this.productsForBuying = new HashSet<>();
        this.productsForSelling = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(nullable = false)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.trim().length() < 3) throw new IllegalArgumentException("Gledai si rabotata");

        this.lastName = lastName;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @ManyToMany
    public Set<User> getFriends() {
        return this.friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    @OneToMany(mappedBy = "buyer")
    public Set<Product> getProductsForBuying() {
        return this.productsForBuying;
    }

    public void setProductsForBuying(Set<Product> productsForBuying) {
        this.productsForBuying = productsForBuying;
    }

    @OneToMany(mappedBy = "seller")
    public Set<Product> getProductsForSelling() {
        return this.productsForSelling;
    }

    public void setProductsForSelling(Set<Product> productsForSelling) {
        this.productsForSelling = productsForSelling;
    }
}
