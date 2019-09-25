package hibernate_excr;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private String first_name;

    @Basic
    private String last_name;

    @Basic
    private String address;

    @Basic
    private String email;

    @Basic
    private LocalDate date_of_birth;

    @Basic
    private byte[] picture;

    @Basic
    private boolean has_medical_insurance;

    @OneToMany(mappedBy = "patient_id")
    private Set<Visitation> visitations;

    @OneToMany(mappedBy = "patient_id")
    private Set<Diagnose> diagnoses;

    @OneToMany(mappedBy = "patient_id")
    private Set<Medicament> perscribed_medicaments;

    public Patient(String first_name, String last_name, String address, String email, LocalDate date_of_birth, byte[] picture, boolean has_medical_insurance, Set<Visitation> visitations, Set<Diagnose> diagnoses, Set<Medicament> perscribed_medicaments) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.picture = picture;
        this.has_medical_insurance = has_medical_insurance;
        this.visitations = visitations;
        this.diagnoses = diagnoses;
        this.perscribed_medicaments = perscribed_medicaments;
    }

    public Patient() {
    }
}
