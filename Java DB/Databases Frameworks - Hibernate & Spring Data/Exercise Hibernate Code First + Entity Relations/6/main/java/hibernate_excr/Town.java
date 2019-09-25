package hibernate_excr;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "town")
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Country country;

    @OneToMany(mappedBy = "town", cascade = CascadeType.ALL)
    private Set<Team> teams;

    public Town() {
    }

    public Town(String name, Country country, Set<Team> teams) {
        this.name = name;
        this.country = country;
        this.teams = teams;
    }
}
