package app.io;

import app.contracts.Writer;

public class ConsoleWriter implements Writer {
    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }
}