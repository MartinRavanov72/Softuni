package main.bg.softuni.io;

import main.bg.softuni.annotations.Alias;
import main.bg.softuni.annotations.Inject;
import main.bg.softuni.contracts.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class CommandInterpreter implements Interpreter {
    private static String COMMANDS_LOCATION = "src/main/bg/softuni/io/commands";
    private static String COMMANDS_PACKAGE = "main.bg.softuni.io.commands.";

    private ContentComparer tester;
    private Database repository;
    private AsynchDownloader downloadManager;
    private DirectoryManager inputOutputManager;

    public CommandInterpreter(ContentComparer tester, Database repository, AsynchDownloader downloadManager, DirectoryManager inputOutputManager) {
        this.tester = tester;
        this.repository = repository;
        this.downloadManager = downloadManager;
        this.inputOutputManager = inputOutputManager;
    }

    public void interpretCommand(String input) throws IOException {
        String[] data = input.split("\\s+");
        String commandName = data[0].toLowerCase();
        try {
            Executable command = parseCommand(input, data, commandName);
            command.execute();
        } catch (Exception ex) {
            OutputWriter.displayException(ex.getMessage());
        }
    }

    private Executable parseCommand(String input, String[] data, String command) {
        File commandsFolder = new File(COMMANDS_LOCATION);
        Executable executable;
        for (File file : commandsFolder.listFiles()) {
            if (!file.isFile() || !file.getName().endsWith(".java")) {
                continue;
            }
            try {
                String className = file.getName().substring(0, file.getName().lastIndexOf('.'));
                Class exeClass = Class.forName(COMMANDS_PACKAGE + className);
                if (!exeClass.isAnnotationPresent(Alias.class)) {
                    continue;
                }
                Alias alias = (Alias) exeClass.getAnnotation(Alias.class);
                String value = alias.value();
                if (!value.equalsIgnoreCase(command)) {
                    continue;
                }
                Constructor exeConstructor = exeClass.getConstructor(String.class, String[].class);
                executable = (Executable) exeConstructor.newInstance(input, data);
                this.injectDependancies(executable, exeClass);
                return executable;
            } catch (ReflectiveOperationException rfe) {
                rfe.printStackTrace();
            }
        }
        return null;
    }

    private void injectDependancies(Executable executable, Class exeClass) throws ReflectiveOperationException {
        Field[] exeFields = exeClass.getDeclaredFields();
        for (Field fieldToSet : exeFields) {
            if (!fieldToSet.isAnnotationPresent(Inject.class)) {
                continue;
            }
            fieldToSet.setAccessible(true);
            Field[] theseFields = CommandInterpreter.class.getDeclaredFields();
            for (Field thisField : theseFields) {
                if (!thisField.getType().equals(fieldToSet.getType())) {
                    continue;
                }
                thisField.setAccessible(true);
                fieldToSet.set(executable, thisField.get(this));
            }
        }
    }
}
