public class Ferrari implements Car {
    private String model;
    private String driver;

    public Ferrari(String driver) {
        this.driver = driver;
        this.model = "488-Spider";
    }

    public String brakes() {
        return "Brakes!";
    }

    public String gas() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.model + "/" + this.brakes() + "/" + this.gas() + "/" + this.driver);
        return sb.toString();
    }
}
