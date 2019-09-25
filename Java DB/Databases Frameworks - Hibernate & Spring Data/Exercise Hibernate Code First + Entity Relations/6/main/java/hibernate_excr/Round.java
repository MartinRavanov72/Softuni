package hibernate_excr;

import javax.persistence.*;

@Entity
@Table(name = "rounds")
public class Round {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    public Round() {
    }

    public Round(String name) {
        this.name = name;
    }
}
