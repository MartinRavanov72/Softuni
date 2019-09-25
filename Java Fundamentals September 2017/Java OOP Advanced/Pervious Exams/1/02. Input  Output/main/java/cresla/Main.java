package cresla;

import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;
import cresla.io.ConsoleInputReader;
import cresla.io.ConsoleOutputWriter;
import cresla.manager.ManagerImpl;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Manager manager = new ManagerImpl();
        OutputWriter writer = new ConsoleOutputWriter();
        InputReader reader = new ConsoleInputReader();

        whileLoop:
        while (true) {
            List<String> commandParams = Arrays.asList(reader.readLine().split("\\s+"));
            switch (commandParams.get(0)) {
                case "Reactor":
                    writer.writeLine(manager.reactorCommand(commandParams.subList(1, commandParams.size())));
                    break;
                case "Module":
                    writer.writeLine(manager.moduleCommand(commandParams.subList(1, commandParams.size())));
                    break;
                case "Report":
                    writer.writeLine(manager.reportCommand(commandParams.subList(1, commandParams.size())));
                    break;
                default:
                    writer.writeLine(manager.exitCommand(commandParams));
                    break whileLoop;

            }
        }
    }
}
