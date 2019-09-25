package app.models.participants;

import app.contracts.Hero;
import app.contracts.Targetable;

public abstract class AbstractHero implements Hero{
    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int level;
    private double health;
    private double damage;
    private double gold;
    private boolean isAlive;

    protected AbstractHero(String name) {
        this.name = name;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public void setStrength(int strength) {

    }

    @Override
    public int getDexterity() {
        return this.dexterity;
    }

    @Override
    public void setDexterity(int dexterity) {

    }

    @Override
    public int getIntelligence() {
        return this.intelligence;
    }

    @Override
    public void setIntelligence(int intelligence) {

    }

    @Override
    public String attack(Targetable target) {
        return null;
    }

    @Override
    public void takeDamage(double damage) {

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public double getDamage() {
        return 0;
    }

    @Override
    public double getHealth() {
        return 0;
    }

    @Override
    public double getGold() {
        return 0;
    }

    @Override
    public void setHealth(double health) {

    }

    @Override
    public void giveReward(Targetable targetable) {

    }

    @Override
    public void receiveReward(double reward) {

    }

    @Override
    public void levelUp() {

    }

    @Override
    public boolean isAlive() {
        return false;
    }
}
