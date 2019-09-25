package org.softuni.mostwanted.domain.dtos.xml;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@XmlRootElement(name = "race")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceXMLImportDto {

    @XmlElement
    private Integer laps;
    @XmlElement(name = "district-name")
    private String districtName;
    @XmlElementWrapper(name = "entries")
    @XmlElement(name = "entry")
    private List<EntryXMLImportDto> entries;

    public RaceXMLImportDto() {
        this.entries = new ArrayList<>();
    }

    public Integer getLaps() {
        return laps;
    }

    public void setLaps(Integer laps) {
        this.laps = laps;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public List<EntryXMLImportDto> getEntries() {
        return entries;
    }

    public void setEntries(List<EntryXMLImportDto> entries) {
        this.entries = entries;
    }
}
