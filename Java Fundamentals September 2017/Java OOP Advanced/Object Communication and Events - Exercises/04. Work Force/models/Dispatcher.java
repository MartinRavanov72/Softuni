package b_secondPrinciple.models;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    private String name;
    private List<NameChangeListener> nameChangeListeners;

    public Dispatcher() {
        this.nameChangeListeners = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
        this.fireNameChangeEvent();
    }

    public void addNameChangeListener(NameChangeListener listener) {
        this.nameChangeListeners.add(listener);
    }

    public void removeNameChangeListener(NameChangeListener listener) {
        this.nameChangeListeners.remove(listener);
    }

    private void fireNameChangeEvent() {
        NameChange event = new NameChange(this.name);
        for (NameChangeListener nameChangeListener : nameChangeListeners) {
            nameChangeListener.handleChangedName(event);
        }
    }
}
