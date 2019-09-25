package hibernate_excr;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visitations")
public class Visitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private LocalDate date;

    @Basic
    private String comments;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient_id;

    public Visitation(LocalDate date, String comments, Patient patient_id) {
        this.date = date;
        this.comments = comments;
        this.patient_id = patient_id;
    }

    public Visitation() {
    }
}
