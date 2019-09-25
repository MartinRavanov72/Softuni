package Avatar;

import Avatar.benders.Bender;
import Avatar.monuments.Monument;

import java.util.ArrayList;
import java.util.List;

public class Nation {
    private String name;
    private List<Bender> benders;
    private List<Monument> monuments;
    private double totalPower;

    Nation(String name) {
        this.name = name;
        this.benders = new ArrayList<>();
        this.monuments = new ArrayList<>();
        this.totalPower = 0;
    }

    public String getName() {
        return name;
    }

    void addBender(Bender bender) {
        this.benders.add(bender);
    }

    void addMonument(Monument monument) {
        this.monuments.add(monument);
    }

    double getTotalPower() {
        long bendersPower = 0;
        for (Bender bender : this.benders) {
            bendersPower += bender.getTotalPower();
        }
        long monumentsPower = 0;
        for (Monument monument : this.monuments) {
            monumentsPower += monument.getPower();
        }
        return bendersPower + ((bendersPower / 100) * monumentsPower);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" Nation").append(System.lineSeparator()).append("Benders:");
        if (this.benders.size() == 0) {
            sb.append(" None");
            sb.append(System.lineSeparator());
        } else {
            sb.append(System.lineSeparator());
            for (Bender bender : this.benders) {
                sb.append("###");
                sb.append(bender.toString());
                sb.append(System.lineSeparator());
            }
        }
        sb.append("Monuments:");
        if (this.monuments.size() == 0) {
            sb.append(" None");
        } else {
            sb.append(System.lineSeparator());
            for (int i = 0; i < this.monuments.size(); i++) {
                sb.append("###");
                sb.append(this.monuments.get(i).toString());
                if (i != this.monuments.size() - 1) {
                    sb.append(System.lineSeparator());
                }
            }
        }
        return sb.toString();
    }
}
