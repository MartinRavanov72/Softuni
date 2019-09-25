package b_secondPrinciple.contracts;

public interface AttackGroup {

    void addMember(Attacker attacker);
    void groupTarget(ObservableTarget target);
    void groupAttack();
}