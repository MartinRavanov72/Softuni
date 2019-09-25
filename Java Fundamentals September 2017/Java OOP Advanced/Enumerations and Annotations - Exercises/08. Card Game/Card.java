package interfaces;

public class Card implements Comparable<Card>{
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return this.rank + " of " + this.suit;
    }

    public int getPower(){
        return this.rank.getPower() + this.suit.getPower();
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.getPower(), o.getPower());
    }
}
