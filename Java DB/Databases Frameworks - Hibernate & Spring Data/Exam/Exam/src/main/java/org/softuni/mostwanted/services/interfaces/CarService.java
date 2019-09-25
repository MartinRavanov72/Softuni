package org.softuni.mostwanted.services.interfaces;

import org.softuni.mostwanted.domain.dtos.json.CarJSONImportDto;

public interface CarService {
    void create(CarJSONImportDto carJSONImportDto);
}
