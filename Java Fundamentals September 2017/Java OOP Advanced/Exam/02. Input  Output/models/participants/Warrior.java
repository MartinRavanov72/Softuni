package app.models.participants;

import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.Config;

public class Warrior implements Hero {
    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int level;
    private double health;
    private double damage;
    private double gold;
    private boolean isAlive;

    public Warrior(){
        this.setStrength(Config.WARRIOR_BASE_STRENGTH);
        this.setDexterity(Config.WARRIOR_BASE_DEXTERITY);
        this.setIntelligence(Config.WARRIOR_BASE_INTELLIGENCE);
        this.level = 1;
        this.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
        this.damage = (this.getStrength() * 2) + this.getDexterity();
        this.isAlive = true;
        this.gold = Config.HERO_START_GOLD;
    }

    public double getReward(){
        this.gold = 0;
        return this.gold;
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
    public int getStrength() {
        return strength;
    }

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
        this.setHealth(strength * Config.HERO_HEALTH_MULTIPLIER);
    }

    @Override
    public int getDexterity() {
        return dexterity;
    }

    @Override
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    @Override
    public int getIntelligence() {
        return intelligence;
    }

    @Override
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public void setHealth(double health) {
        this.health = health;
    }

    @Override
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(this.gold);
        this.gold = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getDamage() {
        return (this.getStrength() * 2) + this.getDexterity();
    }

    @Override
    public double getGold() {
        return this.gold;
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
}
