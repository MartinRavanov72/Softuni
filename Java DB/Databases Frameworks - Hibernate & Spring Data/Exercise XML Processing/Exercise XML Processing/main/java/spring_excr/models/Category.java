package spring_excr.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    private Long id;
    private String name;
    private Set<Product> products;

    public Category() {
        this.products = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column()
    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name.length() < 3 || name.length() > 15) {
            throw new Exception();
        }
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "categories_products",
            joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void setProduct(Product product){
        this.products.add(product);
    }
}
