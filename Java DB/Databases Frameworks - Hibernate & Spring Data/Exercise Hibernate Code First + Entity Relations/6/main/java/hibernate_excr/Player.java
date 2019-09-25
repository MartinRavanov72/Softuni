package hibernate_excr;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "squad_number")
    private int squad_number;

    @ManyToOne(cascade = CascadeType.ALL)
    private Position position;

    @Column(name = "is_injured")
    private boolean is_injured;

    public Player() {
    }

    public Player(String name, int squad_number, Position position, boolean is_injured) {
        this.name = name;
        this.squad_number = squad_number;
        this.position = position;
        this.is_injured = is_injured;
    }
}
