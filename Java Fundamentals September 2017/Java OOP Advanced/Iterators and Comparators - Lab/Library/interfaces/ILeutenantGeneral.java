package interfaces.interfaces;

import interfaces.soldiers.privates.Private;

import java.util.List;

public interface ILeutenantGeneral extends IPrivate {
    void addPrivate(Private p);

    List<Private> getPrivates();
}