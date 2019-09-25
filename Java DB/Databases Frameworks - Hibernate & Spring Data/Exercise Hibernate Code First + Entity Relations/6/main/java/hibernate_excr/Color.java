package hibernate_excr;

import javax.persistence.*;

@Entity
@Table(name = "colors")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    public Color() {
    }

    public Color(String name) {
        this.name = name;
    }
}
