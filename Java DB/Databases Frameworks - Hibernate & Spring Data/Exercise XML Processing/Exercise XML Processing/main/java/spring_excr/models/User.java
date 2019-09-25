package spring_excr.models;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    private Long id;
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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws Exception {
        this.lastName = lastName;
    }

    @Basic
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_friends",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id"))
    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    @OneToMany(mappedBy = "buyer", fetch = FetchType.EAGER)
    public Set<Product> getProductsForBuying() {
        return productsForBuying;
    }

    public void setProductsForBuying(Set<Product> productsForBuying) {
        this.productsForBuying = productsForBuying;
    }

    @OneToMany(mappedBy = "seller", fetch = FetchType.EAGER)
    public Set<Product> getProductsForSelling() {
        return productsForSelling;
    }

    public void setProductsForSelling(Set<Product> productsForSelling) {
        this.productsForSelling = productsForSelling;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
