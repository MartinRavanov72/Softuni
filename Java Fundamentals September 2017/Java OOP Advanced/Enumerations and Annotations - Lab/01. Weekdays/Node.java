package interfaces;

public class Node<T> {
    private Node<T> next;
    private Node<T> previous;
    private T value;

    Node(Node<T> next, Node<T> previous, T value) {
        this.setNext(next);
        this.setPrevious(previous);
        this.setValue(value);
    }

    Node<T> getNext() {
        return this.next;
    }

    void setNext(Node<T> next) {
        this.next = next;
    }

    Node<T> getPrevious() {
        return this.previous;
    }

    void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
