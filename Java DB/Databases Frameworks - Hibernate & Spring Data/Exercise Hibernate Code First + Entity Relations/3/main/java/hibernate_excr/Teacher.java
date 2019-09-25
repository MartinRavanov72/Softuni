package hibernate_excr;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@DiscriminatorValue(value = "Teacher")
public class Teacher extends Person{

    @Basic
    private String email;

    @Basic
    private BigDecimal salary_per_hour;

    public Teacher() {
    }

    public Teacher(String first_name, String last_name, String phone_number, String email, BigDecimal salary_per_hour) {
        super(first_name, last_name, phone_number);
        this.email = email;
        this.salary_per_hour = salary_per_hour;
    }

    @OneToMany(mappedBy = "students", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Course> courses;
}
