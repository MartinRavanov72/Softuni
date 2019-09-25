package hell.entities.heroes;

import hell.interfaces.Inventory;

public class Wizard extends AbstractHero{
    public Wizard(String name, long strength, long agility, long intelligence, long hitPoints, long damage, Inventory inventory) {
        super(name, 25, 25, 100, 100, 250, inventory);
    }
}
