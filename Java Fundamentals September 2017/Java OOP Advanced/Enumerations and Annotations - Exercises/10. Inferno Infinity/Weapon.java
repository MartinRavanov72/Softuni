package interfaces;

public class Weapon {
    private GemType[] gems;
    private WeaponType weaponType;
    private String name;

    Weapon(WeaponType weaponType, String name) {
        this.weaponType = weaponType;
        this.gems = new GemType[this.weaponType.getSockets()];
        this.name = name;
    }

    void addGem(int index, GemType gem) {
        try {
            this.gems[index] = gem;
        } catch (IndexOutOfBoundsException ignored) {}
    }

    void removeGem(int index) {
        try {
            this.gems[index] = null;
        } catch (IndexOutOfBoundsException ignored) {}
    }

    private int getTotalStrength() {
        int totalStrength = 0;
        for (GemType gem : this.gems) {
            if (gem != null) {
                totalStrength += gem.getStrength();
            }
        }
        return totalStrength;
    }

    private int getTotalAgility() {
        int totalAgility = 0;
        for (GemType gem : this.gems) {
            if (gem != null) {
                totalAgility += gem.getAgility();
            }
        }
        return totalAgility;
    }

    private int getTotalVitality() {
        int totalVitality = 0;
        for (GemType gem : this.gems) {
            if (gem != null) {
                totalVitality += gem.getVitality();
            }
        }
        return totalVitality;
    }

    private int getTotalMinDamage() {
        int totalBonus = this.getTotalBonus(2, 1);
        return this.weaponType.getMinDamage() + totalBonus;
    }

    private int getTotalMaxDamage() {
        int totalBonus = this.getTotalBonus(3, 4);
        return this.weaponType.getMaxDamage() + totalBonus;
    }

    private int getTotalBonus(int num1, int num2) {
        int strengthBonus = 0;
        for (GemType gem : this.gems) {
            if (gem != null) {
                strengthBonus += gem.getStrength() * num1;
            }
        }
        int agilityBonus = 0;
        for (GemType gem : this.gems) {
            if (gem != null) {
                agilityBonus += gem.getAgility() * num2;
            }
        }
        return strengthBonus + agilityBonus;
    }

    public String toString() {
        return this.name + ": " + this.getTotalMinDamage() + "-" + this.getTotalMaxDamage() + " Damage, +" + this.getTotalStrength() + " Strength, +" +
                this.getTotalAgility() + " Agility, +" + this.getTotalVitality() + " Vitality";
    }
}
