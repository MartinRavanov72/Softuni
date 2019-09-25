package hibernate_excr;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private Team home_team;

    @OneToOne(cascade = CascadeType.ALL)
    private Team away_team;

    @Column(name = "home_team_goals")
    private int home_team_goals;

    @Column(name = "away_team_goals")
    private int away_team_goals;

    @Column(name = "date_time")
    private LocalDate date_time;

    @Column(name = "home_team_bet_rate")
    private double home_team_bet_rate;

    @Column(name = "away_team_bet_rate")
    private double away_team_bet_rate;

    @Column(name = "draw_game_bet_rate")
    private double draw_game_bet_rate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Round round;

    @ManyToOne(cascade = CascadeType.ALL)
    private Competition competition;

    public Game() {
    }

    public Game(Team home_team, Team away_team, int home_team_goals, int away_team_goals, LocalDate date_time, double home_team_bet_rate, double away_team_bet_rate, double draw_game_bet_rate, Round round, Competition competition) {
        this.home_team = home_team;
        this.away_team = away_team;
        this.home_team_goals = home_team_goals;
        this.away_team_goals = away_team_goals;
        this.date_time = date_time;
        this.home_team_bet_rate = home_team_bet_rate;
        this.away_team_bet_rate = away_team_bet_rate;
        this.draw_game_bet_rate = draw_game_bet_rate;
        this.round = round;
        this.competition = competition;
    }
}
