package hell.core.commands;

import hell.annotations.Inject;
import hell.core.Executable;
import hell.factories.HeroFactory;
import hell.interfaces.Hero;
import hell.interfaces.OutputWriter;
import hell.repositories.Repository;

import java.util.List;

public class HeroCommand implements Executable {
    @Inject
    private List<String> params;
    @Inject
    private Repository repository;
    @Inject
    private OutputWriter writer;

    @Override
    public void execute() {
        Hero hero = HeroFactory.makeHero(this.params.get(0), this.params.get(1));
        this.repository.addHero(hero);
        this.writer.writeLine("Created %s - %s", this.params.get(1), this.params.get(0));
    }
}
