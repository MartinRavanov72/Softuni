package b_secondPrinciple.loggers;

import b_secondPrinciple.abstractClasses.Logger;
import b_secondPrinciple.enumerations.LogType;

public class CombatLogger extends Logger {

    @Override
    public void handle(LogType type, String message) {

        if (type == LogType.ATTACK || type == LogType.MAGIC) {
            System.out.println(type.name() + ": " + message);
        } else {
            super.passToSuccessor(type, message);
        }
    }
}