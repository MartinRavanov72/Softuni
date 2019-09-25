package pr0304Barracks.core.factories;

import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;
import pr0304Barracks.models.units.AbstractUnit;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"pr0304Barracks.models.units.";

	@Override
	public Unit createUnit(String unitType){
	    try {
            Class currentClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor constructor = currentClass.getConstructor();
            return (AbstractUnit) constructor.newInstance();
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException ignored){}
        return null;
    }
}
