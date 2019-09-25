package hibernate_excr;

import javax.persistence.*;

@Entity
@Table(name = "bet_games")
public class BetGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private Game game;

    @OneToOne(cascade = CascadeType.ALL)
    private Bet bet;

    @OneToOne(cascade = CascadeType.ALL)
    private ResultPrediction result_prediction;

    public BetGame() {
    }

    public BetGame(Game game, Bet bet, ResultPrediction result_prediction) {
        this.game = game;
        this.bet = bet;
        this.result_prediction = result_prediction;
    }
}
