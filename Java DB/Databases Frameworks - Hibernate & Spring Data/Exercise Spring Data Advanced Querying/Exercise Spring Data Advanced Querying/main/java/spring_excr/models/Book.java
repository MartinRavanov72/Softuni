package spring_excr.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
    private Integer id;
    private String title;
    private String description;
    private String editionType;
    private BigDecimal price;
    private int copies;
    private Date releaseDate;
    private String ageRestriction;
    private Author authorId;
    private Set<Category> categories;

    public Book(String title, String description, String editionType, BigDecimal price, int copies, Date releaseDate, String ageRestriction, Author authorId, Set<Category> categories) {
        this.title = title;
        this.description = description;
        this.editionType = editionType;
        this.price = price;
        this.copies = copies;
        this.releaseDate = releaseDate;
        this.ageRestriction = ageRestriction;
        this.authorId = authorId;
        this.categories = categories;
    }

    public Book() {
        this.categories = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "title", length = 50, nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description", length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "edition_type", nullable = false)
    public String getEditionType() {
        return editionType;
    }

    public void setEditionType(String editionType) {
        this.editionType = editionType;
    }

    @Column(scale = 2, precision = 19, name = "price", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "copies", nullable = false)
    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    @Column(name = "release_date")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date release_date) {
        this.releaseDate = release_date;
    }

    @Column(name = "age_restriction", nullable = false)
    public String getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(String ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    public Author getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Author author) {
        this.authorId = author;
    }

    @ManyToMany
    @JoinTable(name = "books_categories", joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
