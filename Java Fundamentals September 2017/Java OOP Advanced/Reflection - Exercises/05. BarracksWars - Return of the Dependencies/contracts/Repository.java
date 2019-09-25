package pr0304Barracks.contracts;

import java.lang.reflect.InvocationTargetException;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	String removeUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
