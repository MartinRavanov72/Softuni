package hibernate_excr;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "billing_details")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class BillingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private int number;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user_id;

    public BillingDetail(int number, User user_id) {
        this.number = number;
        this.user_id = user_id;
    }

    public BillingDetail() {
    }
}
