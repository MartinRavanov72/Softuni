package hibernate_excr;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @Column(name = "name_description")
    private int name_description;

    @Basic
    private LocalDate start_date;

    @Basic@Column(name = "ens_date")
    private LocalDate end_date;

    @Basic
    private int credits;

    @ManyToOne(optional = false)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher_id;

    @ManyToMany
    @JoinTable(name = "courses_students", joinColumns = @JoinColumn(name = "course_description", referencedColumnName = "name_description"), inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private Set<Student> students;
}
