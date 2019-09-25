package interfaces.soldiers.privates;

import interfaces.interfaces.ILeutenantGeneral;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeutenantGeneral extends Private implements ILeutenantGeneral {
    private List<Private> privates;

    public LeutenantGeneral(int id, String firstName, String lastName, Double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public void addPrivate(Private p) {
        privates.add(p);
    }

    @Override
    public List<Private> getPrivates() {
        return Collections.unmodifiableList(this.privates);
    }

    @Override
    public String toString() {
        StringBuilder privatesToString = new StringBuilder();
        List<Private> list = new ArrayList<>(this.privates);
        Comparator<Private> comp = (a, b) -> Integer.compare(b.getId(), a.getId());
        Collections.sort(list, comp);
        for (Private private1 : list) {
            privatesToString.append("  ").append(private1.toString());
        }
        privatesToString.append(System.lineSeparator());
        return super.toString() + "Privates:\n" + privatesToString;
    }
}