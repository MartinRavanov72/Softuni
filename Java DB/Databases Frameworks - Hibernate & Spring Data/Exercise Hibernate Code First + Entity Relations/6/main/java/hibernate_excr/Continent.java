package hibernate_excr;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "continents")
public class Continent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "continent", cascade = CascadeType.ALL)
    private Set<Country> countries;

    public Continent() {
    }

    public Continent(String name, Set<Country> countries) {
        this.name = name;
        this.countries = countries;
    }
}
