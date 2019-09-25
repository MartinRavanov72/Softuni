package app.core.commands;

import app.annotations.Inject;
import app.contracts.Battlefield;
import app.contracts.Writer;
import app.core.Executable;
import java.util.List;
import java.util.stream.Collectors;

public class CreateActionCommand implements Executable{
    @Inject
    private List<String> params;
    @Inject
    private Battlefield battlefield;
    @Inject
    private Writer writer;

    @Override
    public void execute() {
        List<String> params = this.params.stream().skip(1).collect(Collectors.toList());
        String[] arr = new String[params.size()];
        for (int i = 0; i < params.size(); i++) {
            arr[i] = params.get(i);
        }
        this.battlefield.createAction(this.params.get(0), arr);
    }
}
