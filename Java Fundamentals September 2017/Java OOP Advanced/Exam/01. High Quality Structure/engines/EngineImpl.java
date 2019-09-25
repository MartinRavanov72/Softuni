package app.engines;

import app.annotations.Inject;
import app.contracts.Battlefield;
import app.contracts.Engine;
import app.contracts.Reader;
import app.contracts.Writer;
import app.core.Executable;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EngineImpl implements Engine {
    private List<String> params;
    private Reader reader;
    private Writer writer;
    private Battlefield battlefield;

    public EngineImpl(Reader reader, Writer writer, Battlefield battlefield) {
        this.reader = reader;
        this.writer = writer;
        this.battlefield = battlefield;
    }

    @Override
    public void run() {
        while (true) {
            List<String> tokens = null;
            try {
                tokens = new ArrayList<>(Arrays.asList(this.reader.readLine().split("\\s+")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            if ("Peace".equals(tokens.get(0))) {
                break;
            }
            try {
                this.dispatchCommand(tokens.get(0), tokens.stream().skip(1).collect(Collectors.toList()));
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                throw new UnsupportedOperationException();
            }
        }
    }

    private void dispatchCommand(String command, List<String> tokens) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        this.params = tokens;
        Class<Executable> commandClass = (Class<Executable>) Class.forName("app.core.commands." + command + "Command");
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
