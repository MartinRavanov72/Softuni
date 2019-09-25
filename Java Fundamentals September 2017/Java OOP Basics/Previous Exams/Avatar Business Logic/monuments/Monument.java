package Avatar.monuments;

public abstract class Monument {
    private String name;

    Monument(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    public abstract int getPower();
}
