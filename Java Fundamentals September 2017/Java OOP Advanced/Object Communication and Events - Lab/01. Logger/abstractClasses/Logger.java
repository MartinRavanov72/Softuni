package b_secondPrinciple.abstractClasses;

import b_secondPrinciple.contracts.Handler;
import b_secondPrinciple.enumerations.LogType;

public abstract class Logger implements Handler {

    private Handler successor;

    protected void passToSuccessor(LogType type, String message) {
        if (successor != null) {
            successor.handle(type, message);
        }
    }

    @Override
    public abstract void handle(LogType logType, String message);

    @Override
    public void setSuccessor(Handler handler) {
        this.successor = handler;
    }
}
