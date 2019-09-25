package a_DefiningClassesEx;

public class GoldenEditionBook extends Book {

    public GoldenEditionBook(String author, String title, double price) {
        super(author, title, price);
        super.price*= 1.3;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
