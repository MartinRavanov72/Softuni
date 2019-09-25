package hibernate_excr;

import javax.persistence.*;

@Entity
@IdClass(MyKey.class)
@Table(name = "employees_projects")
public class Employee_Project {
    @Id
    private int employee_id;

    @Id
    private int project_id;
}
