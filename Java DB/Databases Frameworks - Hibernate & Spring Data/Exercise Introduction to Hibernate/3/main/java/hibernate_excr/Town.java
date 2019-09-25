package hibernate_excr;

import javax.persistence.*;

@Entity
@Table(name = "towns")
public class Town {
    @Id
    @Column(name = "town_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    public Town(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Town() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Town{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
