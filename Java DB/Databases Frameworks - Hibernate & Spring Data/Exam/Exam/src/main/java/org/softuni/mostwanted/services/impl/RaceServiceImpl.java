package org.softuni.mostwanted.services.impl;

import org.softuni.mostwanted.domain.dtos.xml.EntryXMLImportDto;
import org.softuni.mostwanted.domain.dtos.xml.RaceXMLImportDto;
import org.softuni.mostwanted.domain.entities.District;
import org.softuni.mostwanted.domain.entities.Race;
import org.softuni.mostwanted.domain.entities.RaceEntry;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.DistrictRepository;
import org.softuni.mostwanted.repositories.RaceEntryRepository;
import org.softuni.mostwanted.repositories.RaceRepository;
import org.softuni.mostwanted.services.interfaces.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class RaceServiceImpl implements RaceService{
    private final RaceRepository raceRepository;
    private final ModelParser modelParser;
    private final DistrictRepository districtRepository;
    private final RaceEntryRepository raceEntryRepository;

    @Autowired
    public RaceServiceImpl(RaceRepository raceRepository, ModelParser modelParser, DistrictRepository districtRepository, RaceEntryRepository raceEntryRepository) {
        this.raceRepository = raceRepository;
        this.modelParser = modelParser;
        this.districtRepository = districtRepository;
        this.raceEntryRepository = raceEntryRepository;
    }

    @Override
    public void create(RaceXMLImportDto raceXMLImportDto) {
        Race race = new Race();
        race.setLaps(raceXMLImportDto.getLaps());
        District district = this.districtRepository.findByName(raceXMLImportDto.getDistrictName()).get(0);
        race.setDistrict(district);
        Set<RaceEntry> raceEntries = new HashSet<>();
        for (EntryXMLImportDto entryXMLImportDto : raceXMLImportDto.getEntries()) {
            RaceEntry raceEntry = this.raceEntryRepository.findById(entryXMLImportDto.getRaceEntryId());
            raceEntries.add(raceEntry);
        }
        race.setEntries(raceEntries);
        this.raceRepository.save(race);
    }
}
