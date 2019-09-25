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
        return "Card name: " + this.rank.name() + " of " + this.suit.name() + "; Card rank: " + (this.rank.getPower() + this.suit.getPower());
    }

    public int getPower(){
        return this.rank.getPower() + this.suit.getPower();
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.getPower(), o.getPower());
    }
}
