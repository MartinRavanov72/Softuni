package interfaces;

import java.util.*;

public class MyStack implements Iterable {
    private List<Integer> elements;
    private int currentIndex;

    public MyStack() {
        this.elements = new ArrayList<>();
    }

    public void push(int element) {
        this.elements.add(0, element);
    }

    public int pop() {
        return this.elements.remove(0);
    }

    @Override
    public Iterator iterator() {
        return this.elements.iterator();
    }
}
