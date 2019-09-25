package org.softuni.mostwanted.services.interfaces;

import org.softuni.mostwanted.domain.dtos.xml.RaceEntryXMLImportDto;

public interface RaceEntryService {
    void create(RaceEntryXMLImportDto raceEntryXMLImportDto);
}
