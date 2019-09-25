package a_DefiningClassesEx;

public class Cargo {
    private int weight;
    private String type;

    Cargo(int weight, String type){
        this.weight = weight;
        this.type = type;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getType() {
        return this.type;
    }

}
