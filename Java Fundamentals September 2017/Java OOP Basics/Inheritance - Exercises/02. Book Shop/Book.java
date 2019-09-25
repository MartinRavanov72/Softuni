package a_DefiningClassesEx;

public class Book {
    String title;
    String author;
    double price;

    public Book(String author, String title, double price) {
        String[] authorParams = author.split("\\s+");
        if (authorParams.length == 2 && ((int)authorParams[1].charAt(0) >= 48 && (int)authorParams[1].charAt(0) <=57)) {
            throw new IllegalArgumentException("Author not valid!");
        }
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.title)
                .append(System.lineSeparator())
                .append("Author: ").append(this.author)
                .append(System.lineSeparator())
                .append("Price: ").append(String.format("%.1f", this.price))
                .append(System.lineSeparator());
        return sb.toString();
    }
}
