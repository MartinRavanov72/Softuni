package b_secondPrinciple.contracts;

import b_secondPrinciple.enumerations.LogType;

public interface Handler {

    void handle(LogType type, String message);
    void setSuccessor(Handler successor);
}