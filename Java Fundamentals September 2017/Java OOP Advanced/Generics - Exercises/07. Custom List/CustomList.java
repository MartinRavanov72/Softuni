package interfaces;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> elements;

    public CustomList() {
        this.elements = new ArrayList<>();
    }

    public void add(T item){
        this.elements.add(item);
    }

    public T remove(int index){
        return this.elements.remove(index);
    }

    public boolean contains(T element){
        return this.elements.contains(element);
    }

    public void swap(int index1, int index2){
        T temp = this.elements.get(index1);
        this.elements.add(index1, this.elements.get(index2));
        this.elements.remove(index1 + 1);
        this.elements.add(index2, temp);
        this.elements.remove(index2 + 1);
    }

    public int countGreaterThan(T element){
        int count = 0;
        for (T el : this.elements) {
            if (el.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        T max = this.elements.get(0);
        for (int i = 1; i < this.elements.size(); i++) {
            if (max.compareTo(this.elements.get(i)) < 0) {
                max = this.elements.get(i);
            }
        }
        return max;
    }

    public T getMin() {
        T min = this.elements.get(0);
        for (int i = 1; i < this.elements.size(); i++) {
            if (min.compareTo(this.elements.get(i)) > 0) {
                min = this.elements.get(i);
            }
        }
        return min;
    }

    public static List<Integer> getNullIndices (List<?> list) {
        List<Integer> nulls = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                nulls.add(i);
            }
        }
        return nulls;
    }

    public static <T> void flatten(List<? super T> destination, List<List<? extends T>> source) {
        for (List<? extends T> inner : source) {
            destination.addAll(inner);
        }
    }

    public static <T> void addAll(List<? super T> destination, List<? extends T> source) {
        for (T element : source) {
            destination.add(element);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.elements.size(); i++) {
            sb.append(elements.get(i)).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}