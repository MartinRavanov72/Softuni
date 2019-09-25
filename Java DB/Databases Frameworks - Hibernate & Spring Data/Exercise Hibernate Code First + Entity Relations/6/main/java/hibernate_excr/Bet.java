package hibernate_excr;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bets")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "money")
    private double money;

    @Column(name = "date_time")
    private LocalDate date_time;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    public Bet(double money, LocalDate date_time, User user) {
        this.money = money;
        this.date_time = date_time;
        this.user = user;
    }

    public Bet() {
    }
}