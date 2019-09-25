package org.softuni.mostwanted.services.impl;

import org.softuni.mostwanted.domain.dtos.json.CarJSONImportDto;
import org.softuni.mostwanted.domain.entities.Car;
import org.softuni.mostwanted.domain.entities.Racer;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.CarReposotory;
import org.softuni.mostwanted.repositories.RacerRepository;
import org.softuni.mostwanted.services.interfaces.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CarServiceImpl implements CarService{

    private final CarReposotory carReposotory;
    private final ModelParser modelParser;
    private final RacerRepository racerRepository;

    @Autowired
    public CarServiceImpl(CarReposotory carReposotory, ModelParser modelParser, RacerRepository racerRepository) {
        this.carReposotory = carReposotory;
        this.modelParser = modelParser;
        this.racerRepository = racerRepository;
    }


    @Override
    public void create(CarJSONImportDto carJSONImportDto) {
        Car car = this.modelParser.convert(carJSONImportDto, Car.class);
        Racer racer = this.racerRepository.findByName(carJSONImportDto.getRacerName());
        if (racer == null) {

        } else {
            car.setRacer(racer);
        }
        this.carReposotory.save(car);
    }
}
