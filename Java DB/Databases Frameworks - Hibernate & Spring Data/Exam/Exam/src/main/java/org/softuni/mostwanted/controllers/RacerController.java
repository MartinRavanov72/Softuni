package org.softuni.mostwanted.controllers;


import org.softuni.mostwanted.domain.dtos.json.RacerJSONImportDto;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.interfaces.RacerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class RacerController {
    private final RacerService racerService;
    private final Parser parser;

    @Autowired
    public RacerController(RacerService racerService,
                              @Qualifier("JSONParser") Parser parser) {
        this.racerService = racerService;
        this.parser = parser;
    }

    public String importDataFromJSON(String jsonContent) {
        StringBuilder sb = new StringBuilder();
        try {
            RacerJSONImportDto[] racers = parser.read(RacerJSONImportDto[].class, jsonContent);
            Arrays.stream(racers).forEach(a -> {
                boolean hasInvalidData = false;
                if (ValidationUtil.isValid(a)) {
                    try {
                        this.racerService.create(a);
                    } catch (IllegalArgumentException e) {
                        hasInvalidData = true;
                    }
                    if (hasInvalidData) {
                        sb.append("Error: Invalid data.").append(System.lineSeparator());
                    } else {
                        sb.append(String.format("Successfully imported Racer - %s.", a.getName()))
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
