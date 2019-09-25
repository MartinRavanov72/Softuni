package org.softuni.mostwanted.services.interfaces;

import org.softuni.mostwanted.domain.dtos.json.RacerJSONImportDto;

public interface RacerService {
    void create(RacerJSONImportDto racerJSONImportDto);
}
