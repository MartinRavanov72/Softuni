package interfaces;

import java.util.Arrays;
import java.util.List;

public class ListyIterator implements IListyIterator{
    private List<String> elements;
    private int currentIndex;

    public ListyIterator(String... elements) {
        this.elements = Arrays.asList(elements);
        this.currentIndex = 0;
    }

    @Override
    public boolean move() {
        if (this.currentIndex + 1 < this.elements.size()) {
            this.currentIndex = this.currentIndex + 1;
            return true;
        }
        return false;
    }

    @Override
    public boolean hasNext() {
        return this.currentIndex + 1 < this.elements.size();
    }

    @Override
    public String print() {
        if (this.elements.isEmpty()) {
            return "Invalid Operation!";
        }
        return this.elements.get(this.currentIndex);
    }

    @Override
    public String printAll() {
        if (this.elements.isEmpty()) {
            return "Invalid Operation!";
        }
        StringBuilder result = new StringBuilder();
        for (String element : this.elements) {
            result.append(element).append(" ");
        }
        return result.toString().trim();
    }
}
