package hibernate_excr;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "balance")
    private double balance;

    public User() {
    }

    public User(String username, String password, String email, String fullName, double balance) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.balance = balance;
    }
}
