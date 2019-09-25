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

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getAddress_text() {
        return address_text;
    }

    public void setAddress_text(String address_text) {
        this.address_text = address_text;
    }

    public int getTown_id() {
        return town_id;
    }

    public void setTown_id(int town_id) {
        this.town_id = town_id;
    }
}
