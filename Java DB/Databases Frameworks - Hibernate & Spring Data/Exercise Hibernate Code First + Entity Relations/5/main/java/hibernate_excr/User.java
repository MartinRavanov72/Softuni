package hibernate_excr;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private String first_name;

    @Basic
    private String last_name;

    @Basic
    private String email;

    @Basic
    private String password;

    @OneToMany(mappedBy = "user_id")
    private Set<BillingDetail> billing_details;

    public User(String first_name, String last_name, String email, String password, Set<BillingDetail> billing_details) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.billing_details = billing_details;
    }

    public User() {
    }
}
