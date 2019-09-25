package interfaces;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<E> {
    private Deque<E> contents;

    public Jar() {
        this.contents = new ArrayDeque<>();
    }

    public void add (E element) {
        contents.push(element);
    }

    public E remove() {
        return this.contents.pop();
    }
}
