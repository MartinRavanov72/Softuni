package main.bg.softuni.dataStructures;

import java.util.Collection;

public interface SimpleSortedBag<E extends Comparable<E>> extends Iterable<E> {

    boolean remove (E element);

    int capacity();

    void add(E element);

    void addAll(Collection<E> elements);

    int size();

    String joinWith(String joiner);
}
