package hibernate_excr;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "department_id")
    private int departmentId;

    @Column(name = "manager_id")
    private int managerId;

    @Column(name = "hire_date")
    private LocalDate hireData;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "address_id")
    private int address_id;

    public Employee(int id, String firstName, String lastName, String middleName, String jobTitle, int departmentId, int managerId, LocalDate hireData, Double salary, int address_id) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.jobTitle = jobTitle;
        this.departmentId = departmentId;
        this.managerId = managerId;
        this.hireData = hireData;
        this.salary = salary;
        this.address_id = address_id;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public LocalDate getHireData() {
        return hireData;
    }

    public void setHireData(LocalDate hireData) {
        this.hireData = hireData;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }
}