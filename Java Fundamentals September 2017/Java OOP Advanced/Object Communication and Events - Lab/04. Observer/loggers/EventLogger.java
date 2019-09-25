package b_secondPrinciple.loggers;

import b_secondPrinciple.abstractClasses.Logger;
import b_secondPrinciple.enumerations.LogType;

public class EventLogger extends Logger {

    @Override
    public void handle(LogType type, String message) {

        if (type == LogType.EVENT) {
            System.out.println(type.name() + ": " + message);
        } else {
            super.passToSuccessor(type, message);
        }
    }
}