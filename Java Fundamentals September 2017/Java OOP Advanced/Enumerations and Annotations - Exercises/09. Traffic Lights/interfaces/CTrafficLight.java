package interfaces;

import java.util.Iterator;

public class CTrafficLight implements Iterator<TrafficLight> {
    private TrafficLight currentLight;

    public CTrafficLight(TrafficLight currentLight) {
        this.currentLight = currentLight;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public TrafficLight next() {
        switch (this.currentLight.name()) {
            case "RED":
                this.currentLight = TrafficLight.valueOf("GREEN");
                break;
            case "GREEN":
                this.currentLight = TrafficLight.valueOf("YELLOW");
                break;
            default:
                this.currentLight = TrafficLight.valueOf("RED");
                break;
        }
        return this.currentLight;
    }
}