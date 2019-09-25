package hibernate_excr;

import javax.persistence.*;

@Entity
@Table(name = "player_statistics")
public class PlayerStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Game game;

    @ManyToOne(cascade = CascadeType.ALL)
    private Player player;

    @Column(name = "goals")
    private int goals;

    @Column(name = "assists")
    private int assists;

    @Column(name = "minutes_played")
    private int minutes_played;

    public PlayerStatistics() {
    }

    public PlayerStatistics(Game game, Player player, int goals, int assists, int minutes_played) {
        this.game = game;
        this.player = player;
        this.goals = goals;
        this.assists = assists;
        this.minutes_played = minutes_played;
    }
}
