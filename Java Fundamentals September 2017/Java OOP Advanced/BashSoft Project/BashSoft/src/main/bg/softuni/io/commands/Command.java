package main.bg.softuni.io.commands;

import main.bg.softuni.exceptions.InvalidCommandException;
import main.bg.softuni.contracts.Executable;

public abstract class Command implements Executable {

    private String input;
    private String[] data;

    protected Command(String input, String[] data) {
        this.setInput(input);
        this.setData(data);
    }

    String getInput() {
        return input;
    }

    String[] getData() {
        return data;
    }

    private void setInput(String input) {
        if (input == null || input.equals("")) {
            throw new InvalidCommandException(input);
        }
        this.input = input;
    }

    private void setData(String[] data) {
        if (data == null || data.length < 1) {
            throw new InvalidCommandException(data.toString());
        }
        this.data = data;
    }

    public abstract void execute() throws Exception;
}
