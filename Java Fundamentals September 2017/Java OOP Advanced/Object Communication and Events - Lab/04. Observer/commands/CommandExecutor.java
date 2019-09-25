package b_secondPrinciple.commands;

import b_secondPrinciple.contracts.Command;
import b_secondPrinciple.contracts.Executor;

public class CommandExecutor implements Executor {

    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}