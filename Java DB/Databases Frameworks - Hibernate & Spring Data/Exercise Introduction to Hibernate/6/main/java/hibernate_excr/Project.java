package hibernate_excr;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    private int project_id;

    private String name;

    private String description;

    private LocalDate start_date;

    private LocalDate end_date;
}
