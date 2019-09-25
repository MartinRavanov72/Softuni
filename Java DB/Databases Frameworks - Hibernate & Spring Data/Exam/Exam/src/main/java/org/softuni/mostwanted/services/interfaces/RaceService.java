package org.softuni.mostwanted.services.interfaces;

import org.softuni.mostwanted.domain.dtos.xml.RaceXMLImportDto;

public interface RaceService {
    void create(RaceXMLImportDto raceXMLImportDto);
}
