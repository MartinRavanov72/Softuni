package org.softuni.mostwanted.services.interfaces;

import org.softuni.mostwanted.domain.dtos.json.DistrictJSONImportDto;

public interface DistrictService {
    void create(DistrictJSONImportDto districtJSONImportDto);
}
