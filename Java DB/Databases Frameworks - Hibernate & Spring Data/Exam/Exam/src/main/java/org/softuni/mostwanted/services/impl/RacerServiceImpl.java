package org.softuni.mostwanted.services.impl;

import org.softuni.mostwanted.domain.dtos.json.RacerJSONImportDto;
import org.softuni.mostwanted.domain.entities.Racer;
import org.softuni.mostwanted.domain.entities.Town;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.RacerRepository;
import org.softuni.mostwanted.repositories.TownRepository;
import org.softuni.mostwanted.services.interfaces.RacerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RacerServiceImpl implements RacerService{
    private final RacerRepository racerRepository;
    private final ModelParser modelParser;
    private final TownRepository townRepository;


    @Autowired
    public RacerServiceImpl(RacerRepository racerRepository, ModelParser modelParser, TownRepository townRepository) {
        this.racerRepository = racerRepository;
        this.modelParser = modelParser;
        this.townRepository = townRepository;
    }

    @Override
    public void create(RacerJSONImportDto racerJSONImportDto) {
        Racer racer = this.modelParser.convert(racerJSONImportDto, Racer.class);
        Town town = this.townRepository.findByName(racerJSONImportDto.getHomeTown());
        if (town == null) {

        } else {
            racer.setHomeTown(town);
        }
        this.racerRepository.save(racer);
    }
}
