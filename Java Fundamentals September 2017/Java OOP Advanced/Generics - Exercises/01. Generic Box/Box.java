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
}
