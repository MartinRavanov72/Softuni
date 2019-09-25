package interfaces;

import java.util.Iterator;

public class MyList<T> implements Iterable<T>{
    private Node<T> head;
    private Node<T> tail;
    private int numberOfElements;

    public MyList() {
        this.numberOfElements = 0;
        this.head = null;
        this.tail = null;
    }

    public void add(T element) {
        Node<T> node = new Node<>(null, this.tail, element);
        if (this.numberOfElements == 0) {
            this.tail = node;
            this.head = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
        this.numberOfElements++;
    }

    public boolean remove(T element) {
        Node<T> node = this.head;
        while (node != null) {
            if (element == node.getValue()) {
                if (node == this.head) {
                    this.head = node.getNext();
                }
                if ((node == this.tail)) {
                    this.tail = node.getPrevious();
                    this.tail.setNext(null);
                }
                if (node.getPrevious() != null) {
                    node.getPrevious().setNext(node.getNext());
                }
                if (node.getNext() != null) {
                    node.getNext().setPrevious(node.getPrevious());
                }
                this.numberOfElements--;
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    public int getSize() {
        return this.numberOfElements;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> currentNode = head;
            @Override
            public boolean hasNext() {
                return this.currentNode != null;
            }
            @Override
            public T next() {
                T element = this.currentNode.getValue();
                this.currentNode = this.currentNode.getNext();
                return element;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T item : this) {
            sb.append(item).append(" ");
        }
        return sb.toString().trim();
    }
}
