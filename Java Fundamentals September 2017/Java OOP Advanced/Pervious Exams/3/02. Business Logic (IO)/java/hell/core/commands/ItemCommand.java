package hell.core.commands;

import hell.annotations.Inject;
import hell.core.Executable;
import hell.factories.ItemFactory;
import hell.interfaces.Item;
import hell.interfaces.OutputWriter;
import hell.repositories.Repository;

import java.util.List;

public class ItemCommand implements Executable {
    @Inject
    private List<String> params;
    @Inject
    private Repository repository;
    @Inject
    private OutputWriter writer;

    @Override
    public void execute() {
        Item item = ItemFactory.makeCommonItem(this.params.get(0), Integer.parseInt(this.params.get(2)), Integer.parseInt(this.params.get(3)), Integer.parseInt(this.params.get(4)), Integer.parseInt(this.params.get(5)), Integer.parseInt(this.params.get(6)));
        this.repository.getHeroByName(this.params.get(1)).addItem(item);
        this.writer.writeLine("Added item - %s to Hero - %s", this.params.get(0), this.params.get(1));
    }
}
