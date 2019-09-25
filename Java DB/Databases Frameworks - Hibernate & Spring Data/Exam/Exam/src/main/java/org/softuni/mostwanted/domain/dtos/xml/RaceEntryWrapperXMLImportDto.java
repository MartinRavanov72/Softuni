package org.softuni.mostwanted.domain.dtos.xml;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "race-entries")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceEntryWrapperXMLImportDto {

    @XmlElement(name = "race-entry")
    private List<RaceEntryXMLImportDto> raceEntries;


    public RaceEntryWrapperXMLImportDto() {
    }

    public List<RaceEntryXMLImportDto> getRaceEntries() {
        return this.raceEntries;
    }

    public void setRaceEntries(List<RaceEntryXMLImportDto> raceEntries) {
        this.raceEntries = raceEntries;
    }
}

