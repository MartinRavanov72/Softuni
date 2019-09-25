package hibernate_excr;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "store_locations")
public class StoreLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    private String location_name;


    @OneToMany(mappedBy = "store_location_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Sales> sales;

    public StoreLocation(String location_name, Set<Sales> sales) {
        this.location_name = location_name;
        this.sales = sales;
    }

    public StoreLocation() {
    }
}
