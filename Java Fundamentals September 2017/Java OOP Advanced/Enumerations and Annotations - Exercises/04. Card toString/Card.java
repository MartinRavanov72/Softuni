package interfaces;

public class Card {
    private Suit suit;
    private Power power;

    public Card(Suit suit, Power power) {
        this.suit = suit;
        this.power = power;
    }

    @Override
    public String toString() {
        return "Card name: " + this.power.name() + " of " + this.suit.name() + "; Card power: " + (this.power.getPower() + this.suit.getPower());
    }
}
