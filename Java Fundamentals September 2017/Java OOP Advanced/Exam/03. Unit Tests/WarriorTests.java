package myTests;

import app.contracts.Action;
import app.contracts.Targetable;
import app.models.actions.OneVsOne;
import app.models.participants.Warrior;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class WarriorTests {
    private Targetable warrior;
    private Action battle;

    @Before
    public void init(){
        this.warrior = new Warrior();
        this.battle = new OneVsOne();
    }

    @Test
    public void takesDamage() {
        this.warrior.takeDamage(25);
        Assert.assertEquals(25, this.warrior.getHealth(), 0.01);
    }

    @Test
    public void takesZeroDamage() {
        this.warrior.takeDamage(0);
        Assert.assertEquals(50, this.warrior.getHealth(), 0.01);
    }

    @Test
    public void isAlive() {
        Assert.assertEquals(true, this.warrior.isAlive());
    }

    @Test
    public void isAliveAfterDamage() {
        this.warrior.takeDamage(25);
        Assert.assertEquals(true, this.warrior.isAlive());
    }

    @Test
    public void isDeadAfterDamage() {
        this.warrior.takeDamage(60);
        Assert.assertEquals(false, this.warrior.isAlive());
    }

    @Test
    public void levelsUp()  {
        this.warrior.levelUp();
        Assert.assertEquals(28, this.warrior.getDamage(), 0.01);
    }

    @Test
    public void levelUpHealthIncreases()  {
        this.warrior.levelUp();
        this.warrior.levelUp();
        Assert.assertEquals(200, this.warrior.getHealth(), 0.01);
    }

    @Test
    public void receivesReward() throws NoSuchFieldException, IllegalAccessException {
        Targetable warrior2 = new Warrior();
        Class<Warrior> warriorClass = (Class<Warrior>) warrior2.getClass();
        Field field = warriorClass.getDeclaredField("gold");
        field.setAccessible(true);
        double value = (double)field.get(warrior2);
        this.warrior.receiveReward(value);

        warriorClass = (Class<Warrior>) this.warrior.getClass();
        field = warriorClass.getDeclaredField("gold");
        field.setAccessible(true);
        value = (double)field.get(this.warrior);
        Assert.assertEquals(400, value, 0.01);
    }

//    @Test
//    public void executes(){
//        Targetable warrior2 = new Warrior();
//        List<Targetable> participants = new ArrayList<>();
//        participants.add(this.warrior);
//        participants.add(warrior2);
//        this.battle.executeAction(participants);
//
//    }
//
//    @Test
//    public void addRecipeItem()  {
//        this.seedRecipeItems();
//        Recipe mock = mock(Recipe.class);
//        long expectedRecipeItemsLength = 2;
//        this.inventory.addRecipeItem(mock);
//        Field recipeItemsField = this.inventory.getClass().getDeclaredField("recipeItems");
//        recipeItemsField.setAccessible(true);
//        Map<String, Item> recipeItems = (Map<String, Item>) recipeItemsField.get(this.inventory);
//        Assert.assertEquals(expectedRecipeItemsLength, recipeItems.size());
//    }
//
//    @SuppressWarnings("unchecked")
//    private void seedCommonItems() throws {
//        Targetable warrior = new Warrior();
//
//        Field commonItemsField = this.inventory.getClass().getDeclaredField("commonItems");
//        commonItemsField.setAccessible(true);
//        Map<String, Item> commonItems = (Map<String, Item>) commonItemsField.get(this.inventory);
//        Item mock1 = mock(Item.class);
//        when(mock1.getStrengthBonus()).thenReturn(2);
//        when(mock1.getAgilityBonus()).thenReturn(2);
//        when(mock1.getDamageBonus()).thenReturn(2);
//        when(mock1.getHitPointsBonus()).thenReturn(2);
//        when(mock1.getIntelligenceBonus()).thenReturn(2);
//        when(mock1.getName()).thenReturn("commonItemsMock1");
//
//        Item mock2 = mock(Item.class);
//        when(mock2.getStrengthBonus()).thenReturn(-2);
//        when(mock2.getAgilityBonus()).thenReturn(-2);
//        when(mock2.getDamageBonus()).thenReturn(-2);
//        when(mock2.getHitPointsBonus()).thenReturn(-2);
//        when(mock2.getIntelligenceBonus()).thenReturn(-2);
//        when(mock2.getName()).thenReturn("commonItemsMock2");
//
//        Item mock3 = mock(Item.class);
//        when(mock3.getStrengthBonus()).thenReturn(2);
//        when(mock3.getAgilityBonus()).thenReturn(2);
//        when(mock3.getDamageBonus()).thenReturn(2);
//        when(mock3.getHitPointsBonus()).thenReturn(2);
//        when(mock3.getIntelligenceBonus()).thenReturn(2);
//        when(mock3.getName()).thenReturn("commonItemsMock3");
//
//        commonItems.put(mock1.getName(), mock1);
//        commonItems.put(mock2.getName(), mock2);
//        commonItems.put(mock3.getName(), mock3);
//    }
//
//    @SuppressWarnings("unchecked")
//    private void seedRecipeItems() throws NoSuchFieldException, IllegalAccessException {
//        Field recipeItemsField = this.inventory.getClass().getDeclaredField("recipeItems");
//        recipeItemsField.setAccessible(true);
//        Map<String, Recipe> recipeItems = (Map<String, Recipe>) recipeItemsField.get(this.inventory);
//        Recipe mock1 = mock(Recipe.class);
//        when(mock1.getStrengthBonus()).thenReturn(2);
//        when(mock1.getAgilityBonus()).thenReturn(2);
//        when(mock1.getDamageBonus()).thenReturn(2);
//        when(mock1.getHitPointsBonus()).thenReturn(2);
//        when(mock1.getIntelligenceBonus()).thenReturn(2);
//        when(mock1.getName()).thenReturn("recipeItemsMock1");
//        String[] requiredItems = {"commonItemsMock1", "commonItemsMock2", "commonItemsMock3"};
//        when(mock1.getRequiredItems()).thenReturn(Arrays.asList(requiredItems));
//        recipeItems.put(mock1.getName(), mock1);
//    }
}