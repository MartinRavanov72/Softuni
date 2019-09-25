package PawInc.core;

import PawInc.io.ConsoleInputReader;
import PawInc.io.ConsoleOutputWriter;
import PawInc.utilities.InputParser;

import java.util.ArrayList;
import java.util.List;

public class Engine {

    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private HealthManager healthManager;

    public Engine() {
        this.inputReader = new ConsoleInputReader();
        this.outputWriter = new ConsoleOutputWriter();
        this.inputParser = new InputParser();
        this.healthManager = new HealthManager();
    }

    public void run() {
        while (true) {
            String inputLine = this.inputReader.readLine();
            if (inputLine.equals("BEER IS COMING")) {
                break;
            }
            ArrayList<String> commandParams = this.inputParser.parseInput(inputLine);
            this.dispatchCommand(commandParams);
        }
    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.get(0);
        String output;
        switch (command) {
            case "checkCondition":
                output = this.healthManager.checkCondition(commandParams.get(1));
                if (output.length() > 0) {
                    this.outputWriter.writeLine(output);
                }
                break;
            case "createOrganism":
                output = this.healthManager.createOrganism(commandParams.get(1));
                if (output.length() > 0) {
                    this.outputWriter.writeLine(output);
                }
                break;
            case "addCluster":
                output = this.healthManager.addCluster(commandParams.get(1), commandParams.get(2), Integer.parseInt(commandParams.get(3)), Integer.parseInt(commandParams.get(4)));
                if (output.length() > 0) {
                    this.outputWriter.writeLine(output);
                }
                break;
            case "addCell":
                output = this.healthManager.addCell(commandParams.get(1), commandParams.get(2), commandParams.get(3), commandParams.get(4), Integer.parseInt(commandParams.get(5)),
                        Integer.parseInt(commandParams.get(6)), Integer.parseInt(commandParams.get(7)), Integer.parseInt(commandParams.get(8)));
                if (output.length() > 0) {
                    this.outputWriter.writeLine(output);
                }
                break;
            case "activateCluster":
                output = this.healthManager.activateCluster(commandParams.get(1));
                if (output.length() > 0) {
                    this.outputWriter.writeLine(output);
                }
                break;
        }
    }
}
