package hibernate_excr;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    private String name;

    @Basic
    private String email;

    @Basic
    private String credit_card_number;

    @OneToMany(mappedBy = "customer_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Sales> sales;

    public Customer(String name, String email, String credit_card_number, Set<Sales> sales) {
        this.name = name;
        this.email = email;
        this.credit_card_number = credit_card_number;
        this.sales = sales;
    }

    public Customer() {
    }
}
