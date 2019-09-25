package a_DefiningClassesEx;

public class Pokemon {
    private String name;
    private String type;

    Pokemon (String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString () {
        return this.name + " " + this.type + "\n";
    }
}
