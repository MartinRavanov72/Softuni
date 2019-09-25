package hell.entities.items;

import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RecipeItem extends AbstractItem implements Recipe{
    private List<String> requiredItems;

    public RecipeItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus, String... requiredItems) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.requiredItems = Arrays.asList(requiredItems);
    }

    @Override
    public List<String> getRequiredItems() {
        return this.requiredItems;
    }
}
