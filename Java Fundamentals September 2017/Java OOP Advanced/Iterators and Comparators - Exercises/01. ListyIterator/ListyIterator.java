package interfaces;

import java.util.Arrays;
import java.util.List;

public class ListyIterator {
    private List<String> elements;
    private int currentIndex;

    public ListyIterator(String... elements) {
        this.elements = Arrays.asList(elements);
        this.currentIndex = 0;
    }

    public boolean move() {
        if (this.currentIndex + 1 < this.elements.size()) {
            this.currentIndex = this.currentIndex + 1;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.currentIndex + 1 < this.elements.size();
    }

    public String print() {
        if (this.elements.isEmpty()) {
            return "Invalid Operation!";
        }
        return this.elements.get(this.currentIndex);
    }
}
