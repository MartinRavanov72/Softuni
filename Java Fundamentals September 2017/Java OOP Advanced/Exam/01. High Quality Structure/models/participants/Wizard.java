package app.models.participants;

import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.Config;

public class Wizard implements Hero{
    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int level;
    private double health;
    private double damage;
    private double gold;
    private boolean isAlive;

    public Wizard(){
        this.setStrength(Config.WIZARD_BASE_STRENGTH);
        this.setDexterity(Config.WIZARD_BASE_DEXTERITY);
        this.setIntelligence(Config.WIZARD_BASE_INTELLIGENCE);
        this.level = 1;
        this.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
        this.damage = (this.getIntelligence() * 5) + this.getDexterity();
        this.isAlive = true;
        this.gold = Config.HERO_START_GOLD;
    }

    @Override
    public String attack(Targetable target) {
        if (!this.isAlive()) {
            return this.getName() + " is dead! Cannot attack.";
        }

        if (!target.isAlive()){
            return target.getName() + " is dead! Cannot be attacked.";
        }
        target.takeDamage(this.getDamage());
        String result = this.getName() + " attacked!";
        if (!target.isAlive()) {
            this.levelUp();
            target.giveReward(this);
            result += String.format(" %s has been slain by %s.", target.getName(), this.getName());
        }
        return result;
    }

    @Override
    public void receiveReward(double reward){
        this.gold += reward;
    }

    @Override
    public void takeDamage(double damage) {
        this.setHealth(this.getHealth() - damage);
    }


    @Override
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(this.gold);
        this.gold = 0;
    }

    @Override
    public void levelUp() {
        this.setDexterity(this.getDexterity() * Config.LEVEL_UP_MULTIPLIER);
        this.setIntelligence(this.getIntelligence() * Config.LEVEL_UP_MULTIPLIER);
        this.setStrength(this.getStrength() * Config.LEVEL_UP_MULTIPLIER);
        this.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
        this.level += 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("  Name: %s | Class: %s", this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("  Health: %.2f | Damage: %.2f", this.getHealth(), this.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("  %d STR | %d DEX | %d INT | %.2f Gold", this.getStrength(), this.getDexterity(), this.getIntelligence(), this.gold));

        return sb.toString();
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public int getDexterity() {
        return this.dexterity;
    }

    @Override
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    @Override
    public int getIntelligence() {
        return this.intelligence;
    }

    @Override
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getDamage() {
        return (this.getIntelligence() * 5) + this.getDexterity();
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public double getGold() {
        return this.gold;
    }

    @Override
    public void setHealth(double health) {
        this.health = health;
    }

    @Override
    public boolean isAlive() {
        if (!this.isAlive) {
            return false;
        }
        if (this.getHealth() <= 0) {
            this.isAlive = false;
        }
        return this.isAlive;
    }
}
