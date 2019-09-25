package org.softuni.mostwanted.controllers;


import org.softuni.mostwanted.domain.dtos.json.TownJSONImportDto;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.interfaces.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class TownController {
    private final TownService townService;
    private final Parser parser;

    @Autowired
    public TownController(TownService townService,
                           @Qualifier("JSONParser") Parser parser) {
        this.townService = townService;
        this.parser = parser;
    }

    public String importDataFromJSON(String jsonContent) {
        StringBuilder sb = new StringBuilder();
        try {
            TownJSONImportDto[] racers = parser.read(TownJSONImportDto[].class, jsonContent);
            Arrays.stream(racers).forEach(a -> {
                boolean hasInvalidData = false;
                if (ValidationUtil.isValid(a)) {
                    try {
                        this.townService.create(a);
                    } catch (IllegalArgumentException e) {
                        hasInvalidData = true;
                    }
                    if (hasInvalidData) {
                        sb.append("Error: Invalid data.").append(System.lineSeparator());
                    } else {
                        sb.append(String.format("Successfully imported Town - %s.", a.getName()))
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
