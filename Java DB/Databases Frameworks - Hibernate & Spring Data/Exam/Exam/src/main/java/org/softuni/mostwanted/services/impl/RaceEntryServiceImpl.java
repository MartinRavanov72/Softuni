package org.softuni.mostwanted.services.impl;

import org.softuni.mostwanted.domain.dtos.xml.RaceEntryXMLImportDto;
import org.softuni.mostwanted.domain.entities.Car;
import org.softuni.mostwanted.domain.entities.RaceEntry;
import org.softuni.mostwanted.domain.entities.Racer;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.CarReposotory;
import org.softuni.mostwanted.repositories.RaceEntryRepository;
import org.softuni.mostwanted.repositories.RacerRepository;
import org.softuni.mostwanted.services.interfaces.RaceEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RaceEntryServiceImpl implements RaceEntryService{
    private final RaceEntryRepository raceEntryRepository;
    private final ModelParser modelParser;
    private final CarReposotory carReposotory;
    private final RacerRepository racerRepository;

    @Autowired
    public RaceEntryServiceImpl(RaceEntryRepository raceEntryRepository, ModelParser modelParser, CarReposotory carReposotory, RacerRepository racerRepository) {
        this.raceEntryRepository = raceEntryRepository;
        this.modelParser = modelParser;
        this.carReposotory = carReposotory;
        this.racerRepository = racerRepository;
    }

    @Override
    public void create(RaceEntryXMLImportDto raceEntryXMLImportDto) {
        RaceEntry raceEntry = new RaceEntry();
        Car car = carReposotory.findById(raceEntryXMLImportDto.getCarId());
        raceEntry.setCar(car);
        raceEntry.setFinishTime(raceEntryXMLImportDto.getFinishTime());
        raceEntry.setHasFinished(raceEntryXMLImportDto.getHasFinished());
        Racer racer = this.racerRepository.findByName(raceEntryXMLImportDto.getRacerName());
        raceEntry.setRacer(racer);
        this.raceEntryRepository.save(raceEntry);
    }
}
