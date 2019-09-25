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
    private AnimalCenterManager animalCenterManager;

    public Engine() {
        this.inputReader = new ConsoleInputReader();
        this.outputWriter = new ConsoleOutputWriter();
        this.inputParser = new InputParser();
        this.animalCenterManager = new AnimalCenterManager();
    }

    public void run() {
        while (true) {
            String inputLine = this.inputReader.readLine();
            if (inputLine.equals("Paw Paw Pawah")) {
                outputWriter.writeLine(animalCenterManager.toString());
                break;
            }
            ArrayList<String> commandParams = this.inputParser.parseInput(inputLine);
            this.dispatchCommand(commandParams);
        }
    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.get(0);
        switch (command) {

        }
    }
}
