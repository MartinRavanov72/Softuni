package org.softuni.mostwanted.services.impl;

import org.softuni.mostwanted.domain.dtos.json.DistrictJSONImportDto;
import org.softuni.mostwanted.domain.entities.District;
import org.softuni.mostwanted.domain.entities.Town;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.DistrictRepository;
import org.softuni.mostwanted.repositories.TownRepository;
import org.softuni.mostwanted.services.interfaces.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DistrictServiceImpl implements DistrictService{
    private final DistrictRepository districtRepository;
    private final ModelParser modelParser;
    private final TownRepository townRepository;

    @Autowired
    public DistrictServiceImpl(DistrictRepository districtRepository, ModelParser modelParser, TownRepository townRepository) {
        this.districtRepository = districtRepository;
        this.modelParser = modelParser;
        this.townRepository = townRepository;
    }

    @Override
    public void create(DistrictJSONImportDto districtJSONImportDto) {
        District district = this.modelParser.convert(districtJSONImportDto, District.class);
        Town town = this.townRepository.findByName(districtJSONImportDto.getTownName());
        if (town == null) {

        } else {
            district.setTown(town);
        }
        this.districtRepository.save(district);
    }
}
