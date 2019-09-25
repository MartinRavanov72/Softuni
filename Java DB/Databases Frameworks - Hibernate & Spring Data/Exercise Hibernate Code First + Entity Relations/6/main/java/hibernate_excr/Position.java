package hibernate_excr;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "positions")
public class Position {
    @Id
    @Column(length = 2)
    private String id;

    @Column(name = "description")
    private String description;

    public Position() {
    }

    public Position(String description) {
        this.description = description;
    }
}