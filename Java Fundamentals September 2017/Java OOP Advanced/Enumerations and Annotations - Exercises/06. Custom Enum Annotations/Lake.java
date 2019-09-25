package interfaces;

import java.util.Iterator;
import java.util.List;

public class Lake<T> implements Iterable{
    private List<Integer> numbers;

    public Lake(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator{
        private int currentIndex;

        public Frog() {
            this.currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            if (this.currentIndex % 2 == 0) {
                if (this.currentIndex < numbers.size()) {
                    return true;
                }
                if (numbers.size() > 1) {
                    this.currentIndex = 1;
                    return true;
                }
                return false;
            }
            return this.currentIndex < numbers.size();
        }

        @Override
        public Integer next() {
            this.currentIndex += 2;
            return numbers.get(this.currentIndex - 2);
        }
    }
}
