package pr0304Barracks.core;

import pr0304Barracks.contracts.*;
import pr0304Barracks.contracts.Runnable;
import pr0304Barracks.core.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpredCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (ReflectiveOperationException e) {
				e.printStackTrace();
			}
		}
	}

	private String interpredCommand(String[] data, String commandName) throws ReflectiveOperationException {
		String result;
		Class currentClass = Class.forName("pr0304Barracks.core.commands." + (char)(commandName.charAt(0) - 32) + commandName.substring(1, commandName.length()));
		Constructor constructor = currentClass.getConstructor(String[].class, Repository.class, UnitFactory.class);
		Executable command = (Executable) constructor.newInstance(data, this.repository, this.unitFactory);
		return command.execute();
	}

	private String reportCommand(String[] data) {
		String output = this.repository.getStatistics();
		return output;
	}

	private String addUnitCommand(String[] data) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		String unitType = data[1];
		Unit unitToAdd = this.unitFactory.createUnit(unitType);
		this.repository.addUnit(unitToAdd);
		String output = unitType + " added!";
		return output;
	}
	
	private String fightCommand(String[] data) {
		return "fight";
	}
}
