package hibernate_excr;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "university_attendants")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "position")
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private String first_name;

    @Basic
    private String last_name;

    @Basic
    private String phone_number;

    protected Person() {
    }

    public Person(String first_name, String last_name, String phone_number) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
    }
}
