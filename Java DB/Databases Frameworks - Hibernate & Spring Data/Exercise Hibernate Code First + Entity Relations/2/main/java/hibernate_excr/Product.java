package hibernate_excr;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    private String name;

    @Basic
    private double quantity;

    @Basic
    private BigDecimal price;

    @OneToMany(mappedBy = "product_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Sales> sales;

    public Product(String name, double quantity, BigDecimal price, Set<Sales> sales) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.sales = sales;
    }

    public Product() {
    }
}
