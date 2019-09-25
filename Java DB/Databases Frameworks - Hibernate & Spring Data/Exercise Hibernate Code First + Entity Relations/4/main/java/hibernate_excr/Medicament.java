package hibernate_excr;

import javax.persistence.*;


@Entity
@Table(name = "medicaments")
public class Medicament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient_id;

    public Medicament(String name, Patient patient_id) {
        this.name = name;
        this.patient_id = patient_id;
    }

    public Medicament() {
    }
}
