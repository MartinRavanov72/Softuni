package hibernate_excr;

import javax.persistence.*;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private int department_id;

    @Column(name = "name")
    private String name;

    @Column(name = "manager_id")
    private int manager_id;

    public Department(int department_id, String name, int manager_id) {
        this.department_id = department_id;
        this.name = name;
        this.manager_id = manager_id;
    }

    public Department() {
    }
}
