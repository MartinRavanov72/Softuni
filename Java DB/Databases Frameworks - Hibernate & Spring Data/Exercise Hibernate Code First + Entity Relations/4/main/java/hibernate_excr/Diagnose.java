package hibernate_excr;

import javax.persistence.*;

@Entity
@Table(name = "diagnoses")
public class Diagnose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private String name;

    @Basic
    private String comments;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient_id;

    public Diagnose(String name, String comments, Patient patient_id) {
        this.name = name;
        this.comments = comments;
        this.patient_id = patient_id;
    }

    public Diagnose() {
    }
}
