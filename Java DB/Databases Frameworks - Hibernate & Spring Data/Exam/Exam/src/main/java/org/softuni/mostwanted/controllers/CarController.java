package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.domain.dtos.json.CarJSONImportDto;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.interfaces.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class CarController {
    private final CarService carService;
    private final Parser parser;

    @Autowired
    public CarController(CarService carService,
                            @Qualifier("JSONParser") Parser parser) {
        this.carService = carService;
        this.parser = parser;
    }

    public String importDataFromJSON(String jsonContent) {
        StringBuilder sb = new StringBuilder();
        try {
            CarJSONImportDto[] cars = parser.read(CarJSONImportDto[].class, jsonContent);
            Arrays.stream(cars).forEach(a -> {
                boolean hasInvalidData = false;
                if (ValidationUtil.isValid(a)) {
                    try {
                        this.carService.create(a);
                    } catch (IllegalArgumentException e) {
                        hasInvalidData = true;
                    }
                    if (hasInvalidData) {
                        sb.append("Error: Invalid data.").append(System.lineSeparator());
                    } else {
                        sb.append(String.format("Successfully imported Car - %s %s @ %s.", a.getBrand(), a.getModel(), a.getYearOfProduction()))
                                .append(System.lineSeparator());
                    }

                } else {
                    sb.append("Error: Invalid data.").append(System.lineSeparator());
                }

            });
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
