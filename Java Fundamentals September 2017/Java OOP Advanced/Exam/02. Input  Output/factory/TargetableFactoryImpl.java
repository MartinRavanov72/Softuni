package app.factory;

import app.contracts.Targetable;
import app.contracts.TargetableFactory;
import app.models.participants.Boss;
import app.models.participants.Necromancer;
import app.models.participants.Warrior;
import app.models.participants.Wizard;

import java.lang.reflect.InvocationTargetException;

public class TargetableFactoryImpl implements TargetableFactory{
    @Override
    public Targetable create(String name, String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Targetable targetable = null;
        switch (className){
            case "Boss":
                targetable = new Boss();
                targetable.setName(name);
                break;
            case "Necromancer":
                targetable = new Necromancer();
                targetable.setName(name);
                break;
            case "Warrior":
                targetable = new Warrior();
                targetable.setName(name);
                break;
            case "Wizard":
                targetable = new Wizard();
                targetable.setName(name);
                break;
        }
        return targetable;
    }
}
