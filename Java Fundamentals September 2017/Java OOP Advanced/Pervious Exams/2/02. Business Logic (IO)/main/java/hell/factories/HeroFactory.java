package hell.factories;

import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.Wizard;
import hell.interfaces.Hero;

public final class HeroFactory {
    private HeroFactory() {
    }

    public static Hero makeHero(String name, String type) {
        switch (type) {
            case "Barbarian":
                return new Barbarian(name, InventoryFactory.makeInventory());
            case "Assassin":
                return new Assassin(name, InventoryFactory.makeInventory());
            case "Wizard":
                return new Wizard(name, InventoryFactory.makeInventory());
            default:
                return null;
        }
    }
}
