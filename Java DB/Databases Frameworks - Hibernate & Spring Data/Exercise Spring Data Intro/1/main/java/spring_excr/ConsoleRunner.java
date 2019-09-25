package spring_excr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring_excr.enums.AgeRestriction;
import spring_excr.enums.EditionType;
import spring_excr.models.Author;
import spring_excr.models.Book;
import spring_excr.models.Category;
import spring_excr.services.AuthorService;
import spring_excr.services.BookService;
import spring_excr.services.CategoryService;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class ConsoleRunner implements CommandLineRunner{

    @Autowired
    private AuthorService authorService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BookService bookService;

    public ConsoleRunner(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    public ConsoleRunner() {
    }

    @Override
    public void run(String... strings) throws Exception {
        initBooks();
        printAllBookTitlesAfter2000();
        printAuthorsWithBooksReleaseDateBefore1990();
        printAuthorsByBookCount();
        printAllBooksByGeorgePowell();
    }

    private List<Author> initAuthors() throws IOException {
        List<String> allAuthors = Files.readAllLines(Paths.get("C:\\Users\\Martin\\IdeaProjects\\HibernateExrc\\src\\main\\resources\\authors.txt"));
        List<Author> authors = allAuthors.stream().map(s -> {
            String[] authorNames = s.split("\\s+");
            return new Author(authorNames[0], authorNames[1]);
        }).collect(Collectors.toList());
        this.authorService.saveAuthorIntoDb(authors);
        return authors;
    }

    private void initBooks() throws IOException, ParseException {
        FileInputStream input = new FileInputStream(new File("C:\\Users\\Martin\\IdeaProjects\\HibernateExrc\\src\\main\\resources\\books.txt"));
        CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
        decoder.onMalformedInput(CodingErrorAction.IGNORE);
        InputStreamReader reader = new InputStreamReader(input, decoder);
        BufferedReader bufferedReader = new BufferedReader( reader );
        String line = bufferedReader.readLine();
        List<Author> authors = initAuthors();
        List<Category> categories = initCategories();
        while( line != null ) {
            String[] data = line.split("\\s+");
            Random random = new Random();
            int authorIndex = random.nextInt(authors.size());
            Author author = authors.get(authorIndex);
            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            String editionType1 = editionType.toString();
            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(data[1]);
            int copies = Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            String ageRestriction1 = ageRestriction.toString();
            StringBuilder titleBuilder = new StringBuilder();
            for (int j = 5; j < data.length; j++) {
                titleBuilder.append(data[j]).append(" ");
            }
            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(""));
            String title = titleBuilder.toString();
            Book book = new Book();
            book.setAuthorId(author);
            book.setEditionType(editionType1);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction1);
            book.setTitle(title);
            book.getCategories().add(categories.get(random.nextInt(categories.size())));
            book.getCategories().add(categories.get(random.nextInt(categories.size())));
            book.getCategories().add(categories.get(random.nextInt(categories.size())));
            this.bookService.saveBookIntoDb(book);
            line = bufferedReader.readLine();
        }
    }

    private void printAllBooksByGeorgePowell() {
        List<Book> books = this.bookService.findBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateAndTitle("George", "Powell");
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
        System.out.println();
    }

    private void printAuthorsByBookCount() {
        List<Object[]> authors = this.authorService.findAllByOrderByBooksDesc();
        for (Object[] author : authors) {
            System.out.println(author[0] + " " + author[1] + " count:" + author[2]);
        }
        System.out.println();
    }

    private void printAuthorsWithBooksReleaseDateBefore1990() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("1990-01-01");
        List<Author> authors = this.authorService.findAuthorsByBooksReleaseDateBeforeYear(date);
        for (Author author : authors) {
            System.out.println(author.getFirstName() + " " + author.getLastName());
        }
        System.out.println();
    }

    private List<Category> initCategories() throws IOException {
        List<String> allCategories = Files.readAllLines(Paths.get("C:\\Users\\Martin\\IdeaProjects\\HibernateExrc\\src\\main\\resources\\categories.txt"));
        List<Category> categories = allCategories.stream().filter(x -> !x.isEmpty()).map(Category::new).collect(Collectors.toList());
        this.categoryService.saveCategoryIntoDb(categories);
        return categories;
    }

    private void printAllBookTitlesAfter2000() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2000-01-01");
        List<String> titles = this.bookService.allTitlesAfterYear(date);
        for (String title : titles) {
            System.out.println(title);
        }
        System.out.println();
    }
}