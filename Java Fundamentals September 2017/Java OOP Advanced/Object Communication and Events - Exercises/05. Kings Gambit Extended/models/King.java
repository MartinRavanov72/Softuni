package b_secondPrinciple.models;

import b_secondPrinciple.abstractClasses.Royal;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class King extends Royal{

    private Map<String, Royal> royals;

    public King(String name) {
        super(name);
        this.royals = new LinkedHashMap<>();
    }

    public Map<String, Royal> getRoyals() {
        return Collections.unmodifiableMap(royals);
    }

    public void addFootmen(Footman footman) {
        this.royals.put(footman.getName(), footman);
    }

    public void addRoyalGuards(RoyalGuard royalGuard) {
        this.royals.put(royalGuard.getName(), royalGuard);
    }

    public void removeRoyal(Royal royal){
        this.royals.remove(royal.getName());
    }

    @Override
    public void attacked() {
        System.out.println("King " + super.getName() + " is under attack!");
        for (Map.Entry<String, Royal> footman : this.royals.entrySet()) {
            footman.getValue().attacked();
        }
    }

    @Override
    public void killed() {

    }
}
