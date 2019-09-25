package hell.entities.heroes;

import hell.interfaces.Inventory;

public class Wizard extends AbstractHero{
    public Wizard(String name, Inventory inventory) {
        super(name, 25, 25, 100, 100, 250, inventory);
    }
}
