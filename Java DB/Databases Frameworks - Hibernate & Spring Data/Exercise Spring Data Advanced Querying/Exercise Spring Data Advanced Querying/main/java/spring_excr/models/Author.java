package spring_excr.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {
    private Integer id;
    private String firstName;
    private String lastName;
    private Set<Book> books;

    public Author(String firstName, String last_name, Set<Book> books) {
        this.firstName = firstName;
        this.lastName = last_name;
        this.books = books;
    }

    public Author() {
        this.books = new HashSet<>();
    }

    public Author(String firstName, String last_name) {
        this.firstName = firstName;
        this.lastName = last_name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @OneToMany(mappedBy = "authorId")
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
