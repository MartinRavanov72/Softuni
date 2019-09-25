package hibernate_excr;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "wizard_deposits")
public class WizardDeposit {
    @Id
    @Column(name = "id", columnDefinition = "INT(11) UNSIGNED")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", length = 50)
    private String first_name;

    @Column(name = "last_name", length = 60, nullable = false)
    private String last_name;

    @Column(name = "notes", length = 1000)
    private String notes;

    @Column(name = "age", nullable = false, columnDefinition = "INT(11) UNSIGNED")
    private int age;

    @Column(name = "magic_wand_creator", length = 100)
    private String magic_wand_creator;

    @Column(name = "magic_wand_size", columnDefinition = "INT(11) UNSIGNED")
    private int magic_wand_size;

    @Column(name = "deposit_group", length = 20)
    private String deposit_group;

    @Column(name = "deposit_start_date")
    private LocalDate deposit_start_date;

    @Column(name = "deposit_amount")
    private double deposit_amount;

    @Column(name = "deposit_interest")
    private double deposit_interest;

    @Column(name = "deposit_charge")
    private double deposit_charge;

    @Column(name = "deposit_expiration_date")
    private LocalDate deposit_expiration_date;

    @Column(name = "is_deposit_expired")
    private boolean is_deposit_expired;

    public WizardDeposit(String first_name, String last_name, String notes, int age, String magic_wand_creator, int magic_wand_size, String deposit_group, LocalDate deposit_start_date, double deposit_amount, double deposit_interest, double deposit_charge, LocalDate deposit_expiration_date, boolean is_deposit_expired) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.notes = notes;
        this.age = age;
        this.magic_wand_creator = magic_wand_creator;
        this.magic_wand_size = magic_wand_size;
        this.deposit_group = deposit_group;
        this.deposit_start_date = deposit_start_date;
        this.deposit_amount = deposit_amount;
        this.deposit_interest = deposit_interest;
        this.deposit_charge = deposit_charge;
        this.deposit_expiration_date = deposit_expiration_date;
        this.is_deposit_expired = is_deposit_expired;
    }

    public WizardDeposit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMagic_wand_creator() {
        return magic_wand_creator;
    }

    public void setMagic_wand_creator(String magic_wand_creator) {
        this.magic_wand_creator = magic_wand_creator;
    }

    public int getMagic_wand_size() {
        return magic_wand_size;
    }

    public void setMagic_wand_size(int magic_wand_size) {
        this.magic_wand_size = magic_wand_size;
    }

    public String getDeposit_group() {
        return deposit_group;
    }

    public void setDeposit_group(String deposit_group) {
        this.deposit_group = deposit_group;
    }

    public LocalDate getDeposit_start_date() {
        return deposit_start_date;
    }

    public void setDeposit_start_date(LocalDate deposit_start_date) {
        this.deposit_start_date = deposit_start_date;
    }

    public double getDeposit_amount() {
        return deposit_amount;
    }

    public void setDeposit_amount(double deposit_amount) {
        this.deposit_amount = deposit_amount;
    }

    public double getDeposit_interest() {
        return deposit_interest;
    }

    public void setDeposit_interest(double deposit_interest) {
        this.deposit_interest = deposit_interest;
    }

    public double getDeposit_charge() {
        return deposit_charge;
    }

    public void setDeposit_charge(double deposit_charge) {
        this.deposit_charge = deposit_charge;
    }

    public LocalDate getDeposit_expiration_date() {
        return deposit_expiration_date;
    }

    public void setDeposit_expiration_date(LocalDate deposit_expiration_date) {
        this.deposit_expiration_date = deposit_expiration_date;
    }

    public boolean isIs_deposit_expired() {
        return is_deposit_expired;
    }

    public void setIs_deposit_expired(boolean is_deposit_expired) {
        this.is_deposit_expired = is_deposit_expired;
    }
}