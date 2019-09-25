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

        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        findAllByAgeRestrictionIgnoreCase(scanner);

        findAllByEditionTypeIgnoreCaseAndCopiesLessThan();

        findAllByPriceLessThanOrPriceGreaterThan();

        findAllByReleaseDateAfter(scanner);

        findAllByReleaseDateBefore(scanner);

        findAllByFirstNameEndingWith(scanner);

        findAllByTitleContainingIgnoreCase(scanner);

        findAllByAuthorIdLastNameIgnoreCaseStartingWith(scanner);

        findAllByTitleLengthGreaterThan(scanner);

        findAllByOrderByBooksDesc();

        findAllByTitle(scanner);

        increaseCopiesWithAfterDate(scanner);

        deleteBookCopiesLessThan(scanner);

        findAllTitlesByProcedure(scanner);

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

    private List<Category> initCategories() throws IOException {
        List<String> allCategories = Files.readAllLines(Paths.get("C:\\Users\\Martin\\IdeaProjects\\HibernateExrc\\src\\main\\resources\\categories.txt"));
        List<Category> categories = allCategories.stream().filter(x -> !x.isEmpty()).map(Category::new).collect(Collectors.toList());
        this.categoryService.saveCategoryIntoDb(categories);
        return categories;
    }

    private void findAllByAgeRestrictionIgnoreCase(BufferedReader scanner) throws IOException {
        List<Book> books = this.bookService.findAllByAgeRestrictionIgnoreCase(scanner.readLine());
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
        System.out.println();
    }

    private void findAllByEditionTypeIgnoreCaseAndCopiesLessThan() throws IOException {
        List<Book> books = this.bookService.findAllByEditionTypeIgnoreCaseAndCopiesLessThan("GOLD", 5000);
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
        System.out.println();
    }

    private void findAllByPriceLessThanOrPriceGreaterThan() throws IOException {
        List<Book> books = this.bookService.findAllByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40));
        for (Book book : books) {
            System.out.println(book.getTitle() + " - $" + book.getPrice());
        }
        System.out.println();
    }

    private void findAllByReleaseDateAfter(BufferedReader scanner) throws IOException, ParseException {
        List<Book> books = this.bookService.findAllByReleaseDateNot(Integer.parseInt(scanner.readLine()));
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
        System.out.println();
    }

    private void findAllByReleaseDateBefore(BufferedReader scanner) throws ParseException, IOException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date date = format.parse(scanner.readLine());
        List<Book> books = this.bookService.findAllByReleaseDateBefore(date);
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
        System.out.println();
    }

    private void findAllByFirstNameEndingWith(BufferedReader scanner) throws IOException {
        List<Author> authors = this.authorService.findAllByFirstNameEndingWith(scanner.readLine());
        for (Author author : authors) {
            System.out.println(author.getFirstName() + " " + author.getLastName());
        }
        System.out.println();
    }

    private void findAllByTitleContainingIgnoreCase(BufferedReader scanner) throws IOException {
        List<Book> books = this.bookService.findAllByTitleContainingIgnoreCase(scanner.readLine());
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
        System.out.println();
    }

    private void findAllByAuthorIdLastNameIgnoreCaseStartingWith(BufferedReader scanner) throws IOException {
        List<Book> books = this.bookService.findAllByAuthorIdLastNameIgnoreCaseStartingWith(scanner.readLine());
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
        System.out.println();
    }

    private void findAllByTitleLengthGreaterThan(BufferedReader scanner) throws IOException {
        List<Book> books = this.bookService.findAllByTitleLengthGreaterThan(Long.parseLong(scanner.readLine()));
        System.out.println(books.size());
        System.out.println();
    }

    private void findAllByOrderByBooksDesc() throws IOException {
        List<Object[]> authors = this.authorService.findAllByOrderByBooksDesc();
        for (Object[] arr : authors) {
            System.out.println((String)arr[0] + (String)arr[1] + " - " + arr[2]);
        }
        System.out.println();
    }

    private void findAllByTitle(BufferedReader scanner) throws IOException {
        List<Book> books = this.bookService.findAllByTitle(scanner.readLine());
        for (Book book : books) {
            System.out.println(book.getTitle() + " " + book.getEditionType() + " " + book.getAgeRestriction() + " " + book.getPrice());
        }
        System.out.println();
    }

    private void increaseCopiesWithAfterDate(BufferedReader scanner) throws IOException, ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String str = scanner.readLine();
        Date date = format.parse(str);
        int num = Integer.parseInt(scanner.readLine());
        int count = this.bookService.increaseCopiesWithAfterDate(num, date);
        System.out.println(count + " books are released after " + str + " so total of " + count * num + " book copies were added");
        System.out.println();
    }

    private void deleteBookCopiesLessThan(BufferedReader scanner) throws IOException {
        int count = this.bookService.deleteBookCopiesLessThan(Integer.parseInt(scanner.readLine()));
        System.out.println(count + " books were deleted");
        System.out.println();
    }

    private void findAllTitlesByProcedure(BufferedReader scanner) throws IOException {
        String line = scanner.readLine();
        int count = this.bookService.findAllTitlesByProcedure(line.split("\\s+")[0], line.split("\\s+")[1]);
        System.out.println(line.split("\\s+")[0] + " " + line.split("\\s+")[1] + " has written " + count + " books");
        System.out.println();
    }
}