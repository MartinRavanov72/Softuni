package hibernate_excr;

import javax.persistence.*;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "logo")
    private byte[] logo;

    @Column(name = "initials")
    private String initials;

    @ManyToOne(cascade = CascadeType.ALL)
    private Color primary_color_kit;

    @ManyToOne(cascade = CascadeType.ALL)
    private Color secondary_color_kit;

    @ManyToOne(cascade = CascadeType.ALL)
    private Town town;

    @Column(name = "budget")
    private Double budget;

    public Team() {
    }

    public Team(String name, byte[] logo, String initials, Color primary_color_kit, Color secondary_color_kit, Town town, Double budget) {
        this.name = name;
        this.logo = logo;
        this.initials = initials;
        this.primary_color_kit = primary_color_kit;
        this.secondary_color_kit = secondary_color_kit;
        this.town = town;
        this.budget = budget;
    }
}