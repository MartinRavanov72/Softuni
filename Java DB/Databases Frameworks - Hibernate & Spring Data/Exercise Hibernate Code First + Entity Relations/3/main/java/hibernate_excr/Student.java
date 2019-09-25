package hibernate_excr;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@DiscriminatorValue(value = "Student")
public class Student extends Person{

    @Basic
    private double average_grade;

    @Basic
    private int attendance;

    public Student() {
    }

    public Student(String first_name, String last_name, String phone_number, double average_grade, int attendance) {
        super(first_name, last_name, phone_number);
        this.average_grade = average_grade;
        this.attendance = attendance;
    }

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;
}
