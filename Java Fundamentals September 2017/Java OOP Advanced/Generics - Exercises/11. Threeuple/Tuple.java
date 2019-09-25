package interfaces;

public class Tuple<T, E, I> {
    private T item1;
    private E item2;
    private I item3;

    public Tuple(T item1, E item2, I item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return this.item1.toString() + " -> " + this.item2.toString() + " -> " + this.item3.toString();
    }
}
