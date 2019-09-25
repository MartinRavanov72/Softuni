package app;

import app.contracts.Battlefield;
import app.contracts.Engine;
import app.contracts.Reader;
import app.contracts.Writer;
import app.core.BattlefieldImplementation;
import app.engines.EngineImpl;
import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new ConsoleInputReader();
        Writer writer = new ConsoleOutputWriter();
        Battlefield battleField = new BattlefieldImplementation(writer);
        Engine engine = new EngineImpl(reader, writer, battleField);
        engine.run();
    }
}
