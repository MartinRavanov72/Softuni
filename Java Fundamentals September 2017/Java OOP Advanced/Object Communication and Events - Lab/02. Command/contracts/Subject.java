package b_secondPrinciple.contracts;

public interface Subject {

    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObservers();
}