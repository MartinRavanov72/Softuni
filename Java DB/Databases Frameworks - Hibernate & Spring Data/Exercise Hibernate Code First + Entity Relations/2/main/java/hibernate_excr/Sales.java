package hibernate_excr;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product_id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer_id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "store_location_id", referencedColumnName = "id")
    private StoreLocation store_location_id;

    @Basic
    private LocalDate date;

    public Sales(Product product_id, Customer customer_id, StoreLocation store_location_id, LocalDate date_id) {
        this.product_id = product_id;
        this.customer_id = customer_id;
        this.store_location_id = store_location_id;
        this.date = date_id;
    }

    public Sales() {
    }
}
