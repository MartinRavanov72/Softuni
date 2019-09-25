package hell.engines;

import hell.annotations.Inject;
import hell.core.Executable;
import hell.interfaces.InputReader;
import hell.interfaces.OutputWriter;
import hell.repositories.Repository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine implements Runnable {
    private List<String> params;
    private InputReader reader;
    private OutputWriter writer;
    private Repository repository;

    public Engine(InputReader reader, OutputWriter writer, Repository repository) {
        this.reader = reader;
        this.writer = writer;
        this.repository = repository;
    }

    @Override
    public void run() {
        while (true) {
            List<String> tokens = new ArrayList<>(Arrays.asList(this.reader.readLine().split("\\s+")));
            try {
                this.dispatchCommand(tokens.get(0), tokens.stream().skip(1).collect(Collectors.toList()));
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
            if ("Quit".equals(tokens.get(0))) {
                break;
            }
        }
    }

    private void dispatchCommand(String command, List<String> tokens) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        this.params = tokens;
        Class<Executable> commandClass = (Class<Executable>) Class.forName("hell.core.commands." + command + "Command");
        Executable executable = commandClass.newInstance();
        injectDependencies(executable);
        executable.execute();
    }

    private void injectDependencies(Executable executable) throws IllegalAccessException {
        Field[] fields = executable.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                Field[] currentFields = this.getClass().getDeclaredFields();
                for (Field currentField : currentFields) {
                    if (field.getType().equals(currentField.getType())) {
                        field.setAccessible(true);
                        field.set(executable, currentField.get(this));
                    }
                }
            }
        }
    }
}
