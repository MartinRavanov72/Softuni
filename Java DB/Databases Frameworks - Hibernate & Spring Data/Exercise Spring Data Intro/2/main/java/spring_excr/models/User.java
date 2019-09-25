package spring_excr.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "profile_picture", columnDefinition = "LONGBLOB", length = 1000000)
    private byte[] profilePicture;

    @Column(name = "registered_on")
    private LocalDateTime registeredOn;

    @Column(name = "last_time_logged_in")
    private LocalDateTime lastTimeLoggedIn;

    @Column(name = "age")
    private Integer age;

    @Column(name = "id_deleted")
    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "birth_town")
    private Town birthTown;

    @ManyToOne
    @JoinColumn(name = "current_town")
    private Town currentTown;

    @OneToMany(mappedBy = "owner")
    private Set<Album> albums;

    public User() {
    }

    public Long getId() {
        return id;
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

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username.length() < 4 || username.length() > 30) {
            System.out.println("Username should be between 4 and 30 chars long");
        } else {
            this.username = username;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (isValid(password)) {
            this.password = password;
        } else {
            System.out.println("Please enter a valid password");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String pattern = "^[a-zA-Z0-9]+[-_.]*[a-zA-Z0-9]+@[a-zA-Z0-9]+[-_.]*[a-zA-Z0-9](\\.[a-zA-Z0-9]+[-_.]*[a-zA-Z0-9]+)+$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(email);
        if (m.find()) {
            this.email = email;
        } else {
            System.out.println("Please provide a valid email address");
        }

    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public LocalDateTime getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDateTime registeredOn) {
        this.registeredOn = registeredOn;
    }

    public LocalDateTime getLastTimeLoggedIn() {
        return lastTimeLoggedIn;
    }

    public void setLastTimeLoggedIn(LocalDateTime lastTimeLoggedIn) {
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if (age < 1 || age > 120) {
            System.out.println("Age should be between 1 and 120");
        } else {
            this.age = age;
        }
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Town getBirthTown() {
        return birthTown;
    }

    public void setBirthTown(Town birthTown) {
        this.birthTown = birthTown;
    }

    public Town getCurrentTown() {
        return currentTown;
    }

    public void setCurrentTown(Town currentTown) {
        this.currentTown = currentTown;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    public boolean isValid(String password) {
        if (password == null || password.length() < 6 || password.length() > 50) {
            return false;
        }
        boolean upper = false;
        boolean lower = false;
        boolean digit = false;
        boolean specialSymbol = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                upper = true;
                break;
            }
        }
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                lower = true;
                break;
            }
        }

        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                digit = true;
                break;
            }
        }

        List<Character> specialSymbols = new ArrayList<>();
        Collections.addAll(specialSymbols, '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+', '<', '>', '?');
        for (int i = 0; i < password.length(); i++) {
            if (specialSymbols.contains(password.charAt(i))) {
                specialSymbol = true;
                break;
            }
        }
        return upper && lower && digit && specialSymbol;
    }
}