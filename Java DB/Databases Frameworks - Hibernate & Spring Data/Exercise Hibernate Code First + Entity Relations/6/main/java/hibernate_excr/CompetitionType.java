package hibernate_excr;

import javax.persistence.*;

@Entity
@Table(name = "competition_types")
public class CompetitionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    public CompetitionType() {
    }

    public CompetitionType(String name) {
        this.name = name;
    }
}
