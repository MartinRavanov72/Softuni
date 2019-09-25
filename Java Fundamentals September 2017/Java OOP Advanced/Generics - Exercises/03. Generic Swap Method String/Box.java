package interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T> {
    private List<T> storage;

    public Box() {
        this.storage = new ArrayList<>();
    }

    public void addToStorage(T item){
        this.storage.add(item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.storage.size(); i++) {
            sb.append(storage.get(i).getClass().getCanonicalName() + ": " + storage.get(i)).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public void swap(int index1, int index2){
        T temp = this.storage.get(index1);
        this.storage.add(index1, this.storage.get(index2));
        this.storage.remove(index1 + 1);
        this.storage.add(index2, temp);
        this.storage.remove(index2 + 1);


    }
}
