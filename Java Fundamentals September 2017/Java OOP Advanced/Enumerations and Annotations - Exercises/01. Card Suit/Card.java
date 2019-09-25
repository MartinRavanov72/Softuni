package interfaces;

public enum Card {
    CLUBS, DIAMONDS, HEARTS, SPADES;


    @Override
    public String toString() {
        return "Ordinal value: " + this.ordinal() + "; Name value: " + this.name();
    }
}
