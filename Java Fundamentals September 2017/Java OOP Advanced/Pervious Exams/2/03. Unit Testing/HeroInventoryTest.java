package myTests;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HeroInventoryTest {
    private Inventory inventory;

    @Before
    public void init() throws NoSuchFieldException, IllegalAccessException {
        this.inventory = new HeroInventory();
        this.seedCommonItems();
    }

    @Test
    public void getTotalStrengthBonus() throws NoSuchFieldException, IllegalAccessException {
        Assert.assertEquals(2, this.inventory.getTotalStrengthBonus());
    }

    @Test
    public void getTotalStrengthBonusTestWrongResultWorkCorrectly() throws NoSuchFieldException, IllegalAccessException {
        Assert.assertNotEquals(0, this.inventory.getTotalStrengthBonus());
    }

    @Test
    public void getTotalAgilityBonus() throws IllegalAccessException {
        Assert.assertEquals(2, this.inventory.getTotalAgilityBonus());
    }

    @Test
    public void getTotalIntelligenceBonus() throws IllegalAccessException {
        Assert.assertEquals(2, this.inventory.getTotalIntelligenceBonus());
    }

    @Test
    public void getTotalHitPointsBonus() throws IllegalAccessException {
        Assert.assertEquals( 2, this.inventory.getTotalHitPointsBonus());
    }

    @Test
    public void getTotalDamageBonus() throws IllegalAccessException {
        Assert.assertEquals(2, this.inventory.getTotalDamageBonus());
    }

    @Test
    public void addCommonItemShouldCreateNewItemAndRemoveRecipeComponents() throws NoSuchFieldException, IllegalAccessException {
        this.seedRecipeItems();
        Item mock = mock(Item.class);
        long expectedCommonItemsLength = 2;
        this.inventory.addCommonItem(mock);
        Field commonItemsField = this.inventory.getClass().getDeclaredField("commonItems");
        commonItemsField.setAccessible(true);
        Map<String, Item> commonItems = (Map<String, Item>) commonItemsField.get(this.inventory);
        Assert.assertEquals(expectedCommonItemsLength, commonItems.size());
    }

    @Test
    public void addRecipeItem() throws IllegalAccessException, NoSuchFieldException {
        this.seedRecipeItems();
        Recipe mock = mock(Recipe.class);
        long expectedRecipeItemsLength = 2;
        this.inventory.addRecipeItem(mock);
        Field recipeItemsField = this.inventory.getClass().getDeclaredField("recipeItems");
        recipeItemsField.setAccessible(true);
        Map<String, Item> recipeItems = (Map<String, Item>) recipeItemsField.get(this.inventory);
        Assert.assertEquals(expectedRecipeItemsLength, recipeItems.size());
    }

    @SuppressWarnings("unchecked")
    private void seedCommonItems() throws NoSuchFieldException, IllegalAccessException {
        Field commonItemsField = this.inventory.getClass().getDeclaredField("commonItems");
        commonItemsField.setAccessible(true);
        Map<String, Item> commonItems = (Map<String, Item>) commonItemsField.get(this.inventory);
        Item mock1 = mock(Item.class);
        when(mock1.getStrengthBonus()).thenReturn(2);
        when(mock1.getAgilityBonus()).thenReturn(2);
        when(mock1.getDamageBonus()).thenReturn(2);
        when(mock1.getHitPointsBonus()).thenReturn(2);
        when(mock1.getIntelligenceBonus()).thenReturn(2);
        when(mock1.getName()).thenReturn("commonItemsMock1");

        Item mock2 = mock(Item.class);
        when(mock2.getStrengthBonus()).thenReturn(-2);
        when(mock2.getAgilityBonus()).thenReturn(-2);
        when(mock2.getDamageBonus()).thenReturn(-2);
        when(mock2.getHitPointsBonus()).thenReturn(-2);
        when(mock2.getIntelligenceBonus()).thenReturn(-2);
        when(mock2.getName()).thenReturn("commonItemsMock2");

        Item mock3 = mock(Item.class);
        when(mock3.getStrengthBonus()).thenReturn(2);
        when(mock3.getAgilityBonus()).thenReturn(2);
        when(mock3.getDamageBonus()).thenReturn(2);
        when(mock3.getHitPointsBonus()).thenReturn(2);
        when(mock3.getIntelligenceBonus()).thenReturn(2);
        when(mock3.getName()).thenReturn("commonItemsMock3");

        commonItems.put(mock1.getName(), mock1);
        commonItems.put(mock2.getName(), mock2);
        commonItems.put(mock3.getName(), mock3);
    }

    @SuppressWarnings("unchecked")
    private void seedRecipeItems() throws NoSuchFieldException, IllegalAccessException {
        Field recipeItemsField = this.inventory.getClass().getDeclaredField("recipeItems");
        recipeItemsField.setAccessible(true);
        Map<String, Recipe> recipeItems = (Map<String, Recipe>) recipeItemsField.get(this.inventory);
        Recipe mock1 = mock(Recipe.class);
        when(mock1.getStrengthBonus()).thenReturn(2);
        when(mock1.getAgilityBonus()).thenReturn(2);
        when(mock1.getDamageBonus()).thenReturn(2);
        when(mock1.getHitPointsBonus()).thenReturn(2);
        when(mock1.getIntelligenceBonus()).thenReturn(2);
        when(mock1.getName()).thenReturn("recipeItemsMock1");
        String[] requiredItems = {"commonItemsMock1", "commonItemsMock2", "commonItemsMock3"};
        when(mock1.getRequiredItems()).thenReturn(Arrays.asList(requiredItems));
        recipeItems.put(mock1.getName(), mock1);
    }
}