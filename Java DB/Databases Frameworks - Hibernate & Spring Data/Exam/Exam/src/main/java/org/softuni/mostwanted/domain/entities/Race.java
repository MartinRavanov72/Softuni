package org.softuni.mostwanted.domain.entities;

import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "races")
public class Race{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer laps;

    @ManyToOne(optional = false)
    @JoinColumn(name = "district")
    private District district;

    @OneToMany(mappedBy = "race")
    private Set<RaceEntry> entries;

    public Race() {
        this.entries = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLaps() {
        return laps;
    }

    public void setLaps(Integer laps) {
        this.laps = laps;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Set<RaceEntry> getEntries() {
        return entries;
    }

    public void setEntries(Set<RaceEntry> entries) {
        this.entries = entries;
    }
}
