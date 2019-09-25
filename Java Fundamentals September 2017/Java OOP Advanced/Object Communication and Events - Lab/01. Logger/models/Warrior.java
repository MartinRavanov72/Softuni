package b_secondPrinciple.models;

import b_secondPrinciple.abstractClasses.AbstractHero;
import b_secondPrinciple.contracts.Handler;
import b_secondPrinciple.contracts.Target;
import b_secondPrinciple.enumerations.LogType;

public class Warrior extends AbstractHero {

    private static final String ATTACK_MESSAGE = "%s damages %s for %s";

    public Warrior(String id, int dmg, Handler logger) {
        super(id, dmg, logger);
    }

    @Override
    protected void executeClassSpecificAttack(Target target, int dmg, Handler logger) {
        logger.handle(LogType.ATTACK, String.format(ATTACK_MESSAGE, this, target, dmg));
        target.receiveDamage(dmg);
    }
}