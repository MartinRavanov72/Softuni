package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;

import java.util.ArrayList;
import java.util.List;

public class OneVsOne implements Action {
    private List<Targetable> participants;

    public OneVsOne() {
        this.participants = new ArrayList<>();
    }

    public String executeAction(List<Targetable> participants) {
        this.participants = participants;
        String errorMessage = "There should be exactly 2 participants for OneVsOne!";
        StringBuilder sb = new StringBuilder();
        if (this.participants.size() != 2) {
            return errorMessage;
        }
        Targetable firstHero = participants.get(0);
        Targetable secondHero = participants.get(1);
        while (firstHero.isAlive() && secondHero.isAlive()){
            sb.append(firstHero.attack(secondHero)).append(System.lineSeparator());
            if (secondHero.isAlive()) {
                sb.append(secondHero.attack(firstHero)).append(System.lineSeparator());
            }else {
                break;
            }
        }
        if (firstHero.isAlive()){
            secondHero.giveReward(firstHero);
            sb.append(String.format("%s is victorious!%s%s", firstHero.getName(), System.lineSeparator(),firstHero.toString()));
        }else {
            firstHero.giveReward(secondHero);
            sb.append(String.format("%s is victorious!%s%s", secondHero.getName(), System.lineSeparator(),secondHero.toString()));
        }
        return sb.toString();
    }
}
