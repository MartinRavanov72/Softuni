package org.softuni.mostwanted.domain.dtos.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "entry")
@XmlAccessorType(XmlAccessType.FIELD)
public class EntryXMLImportDto {
    @XmlAttribute(name = "id")
    private Integer raceEntryId;

    public EntryXMLImportDto() {
    }

    public Integer getRaceEntryId() {
        return raceEntryId;
    }

    public void setRaceEntryId(Integer raceEntryId) {
        this.raceEntryId = raceEntryId;
    }
}
