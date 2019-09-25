package app.core.commands;

import app.annotations.Inject;
import app.contracts.Battlefield;
import app.contracts.Writer;
import app.core.Executable;

import java.util.List;

public class StatActionsCommand implements Executable {
    @Inject
    private List<String> params;
    @Inject
    private Battlefield battlefield;
    @Inject
    private Writer writer;

    @Override
    public void execute() {
        this.battlefield.reportActions();
    }
}
