package hell.entities.heroes;

import hell.interfaces.Inventory;

public class Barbarian extends AbstractHero{
    public Barbarian(String name, long strength, long agility, long intelligence, long hitPoints, long damage, Inventory inventory) {
        super(name, 90, 25, 10, 350, 150, inventory);
    }
}
