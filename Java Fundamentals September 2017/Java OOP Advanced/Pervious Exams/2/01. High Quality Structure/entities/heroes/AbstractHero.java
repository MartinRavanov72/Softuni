package hell.entities.heroes;

import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.util.Collection;
import java.util.Map;

public abstract class AbstractHero implements Hero{
    private String name;
    private long strength;
    private long agility;
    private long intelligence;
    private long hitPoints;
    private long damage;
    private Inventory inventory;

    AbstractHero(String name, long strength, long agility, long intelligence, long hitPoints, long damage, Inventory inventory) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = inventory;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength;
    }

    @Override
    public long getAgility() {
        return this.agility;
    }

    @Override
    public long getIntelligence() {
        return this.intelligence;
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints;
    }

    @Override
    public long getDamage() {
        return this.damage;
    }

    @Override
    public Collection<Item> getItems() {
        return null;
    }

    @Override
    public void addItem(Item item) {

    }

    @Override
    public void addRecipe(Recipe recipe) {

    }
}
