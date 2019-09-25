package hibernate_excr;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int address_id;

    private String address_text;

    private int town_id;

    public Address(String address_text, int town_id) {
        this.address_text = address_text;
        this.town_id = town_id;
    }

    public Address() {
    }
}
