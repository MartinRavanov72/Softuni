package org.softuni.mostwanted.services.interfaces;

import org.softuni.mostwanted.domain.dtos.json.TownJSONImportDto;

public interface TownService {
    void create(TownJSONImportDto townJSONImportDto);
}
