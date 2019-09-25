package org.softuni.mostwanted.domain.dtos.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "races")
@XmlAccessorType(XmlAccessType.FIELD)
public class RacesWrapperXMLImportDto {

    @XmlElement(name = "race")
    private List<RaceXMLImportDto> races;

    public RacesWrapperXMLImportDto() {
    }

    public List<RaceXMLImportDto> getRaces() {
        return this.races;
    }

    public void setRaces(List<RaceXMLImportDto> races) {
        this.races = races;
    }
}
