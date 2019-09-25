package hibernate_excr;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @Column(length = 3)
    private String id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Continent continent;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<Town> towns;

    public Country() {
    }

    public Country(String name, Continent continent, Set<Town> towns) {
        this.name = name;
        this.continent = continent;
        this.towns = towns;
    }
}
