package org.softuni.mostwanted.services.impl;

import org.softuni.mostwanted.domain.dtos.json.TownJSONImportDto;
import org.softuni.mostwanted.domain.entities.Town;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.TownRepository;
import org.softuni.mostwanted.services.interfaces.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TownServiceImpl implements TownService{
    private final TownRepository townRepository;
    private final ModelParser modelParser;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, ModelParser modelParser) {
        this.townRepository = townRepository;
        this.modelParser = modelParser;
    }

    @Override
    public void create(TownJSONImportDto townJSONImportDto) {
        Town town = this.modelParser.convert(townJSONImportDto, Town.class);
        this.townRepository.saveAndFlush(town);
    }
}
