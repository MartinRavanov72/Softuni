package org.softuni.mostwanted.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "race_entries")
public class RaceEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Boolean hasFinished;

    @Column
    private Double finishTime;

    @ManyToOne
    @JoinColumn(name = "car")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "racer")
    private Racer racer;

    @ManyToOne
    @JoinColumn(name = "race")
    private Race race;

    public RaceEntry() {
    }

    public Integer getId() {
        return id;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getHasFinished() {
        return hasFinished;
    }

    public void setHasFinished(Boolean hasFinished) {
        this.hasFinished = hasFinished;
    }

    public Double getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Double finishTime) {
        this.finishTime = finishTime;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Racer getRacer() {
        return racer;
    }

    public void setRacer(Racer racer) {
        this.racer = racer;
    }
}
