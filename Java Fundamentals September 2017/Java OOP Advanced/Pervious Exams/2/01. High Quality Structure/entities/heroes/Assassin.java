package hell.entities.heroes;

import hell.interfaces.Inventory;

public class Assassin extends AbstractHero{
    public Assassin(String name, long strength, long agility, long intelligence, long hitPoints, long damage, Inventory inventory) {
        super(name, 25, 100, 15, 150, 300, inventory);
    }
}
