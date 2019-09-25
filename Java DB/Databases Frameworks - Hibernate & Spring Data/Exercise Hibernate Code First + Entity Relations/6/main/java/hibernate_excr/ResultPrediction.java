package hibernate_excr;

import javax.persistence.*;

@Entity
@Table(name = "result_predictions")
public class ResultPrediction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "prediction")
    private String prediction;

    public ResultPrediction() {
    }

    public ResultPrediction(String prediction) {
        this.prediction = prediction;
    }
}
