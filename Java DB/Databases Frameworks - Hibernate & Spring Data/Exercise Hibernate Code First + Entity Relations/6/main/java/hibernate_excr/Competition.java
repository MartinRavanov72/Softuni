package hibernate_excr;

import javax.persistence.*;

@Entity
@Table(name = "competitions")
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private CompetitionType type;

    public Competition() {
    }

    public Competition(String name, CompetitionType type) {
        this.name = name;
        this.type = type;
    }
}
