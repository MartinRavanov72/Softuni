package pr0304Barracks.data;

import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.Unit;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.TreeMap;

public class UnitRepository implements Repository {

	private Map<String, Integer> amountOfUnits;

	public UnitRepository() {
		this.amountOfUnits = new TreeMap<>();
	}

	public void addUnit(Unit unit) {
		String unitType = unit.getClass().getSimpleName();
		if (!this.amountOfUnits.containsKey(unitType)) {
			this.amountOfUnits.put(unitType, 0);
		}

		int newAmount = this.amountOfUnits.get(unitType) + 1;
		this.amountOfUnits.put(unitType, newAmount);
	}

	public String getStatistics() {
		StringBuilder statBuilder = new StringBuilder();
		for (Map.Entry<String, Integer> entry : amountOfUnits.entrySet()) {
			String formatedEntry =
					String.format("%s -> %d%n", entry.getKey(), entry.getValue());
			statBuilder.append(formatedEntry);
		}
		statBuilder.setLength(
				statBuilder.length() - System.lineSeparator().length());

		return statBuilder.toString();
	}

	public String removeUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Class currentClass = Class.forName("pr0304Barracks.models.units." + unitType);
		if (this.amountOfUnits.containsKey(unitType)) {
			this.amountOfUnits.put(unitType, this.amountOfUnits.get(unitType) - 1);
			return currentClass.getSimpleName() + " retired!";
		} else {
			return "No such units in repository.";
		}
	}
}
