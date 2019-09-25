package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.domain.dtos.xml.RacesWrapperXMLImportDto;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.interfaces.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class RaceController {
    private final RaceService raceService;
    private final Parser parser;
    private int count = 1;

    @Autowired
    public RaceController(RaceService raceService,
                              @Qualifier("XMLParser") Parser parser) {
        this.raceService = raceService;
        this.parser = parser;
    }

    public String importDataFromXML(String xmlContext) {
        StringBuilder sb = new StringBuilder();
        try {
            RacesWrapperXMLImportDto races = parser.read(RacesWrapperXMLImportDto.class, xmlContext);
            races.getRaces().forEach(a -> {
                boolean hasInvalidData = false;
                if (ValidationUtil.isValid(a)) {
                    try {
                        this.raceService.create(a);
                    } catch (IllegalArgumentException e) {
                        hasInvalidData = true;
                    }
                    if (hasInvalidData) {
                        sb.append("Error: Invalid data.").append(System.lineSeparator());
                    } else {
                        sb.append(String.format("Successfully imported Race - %s.", count))
                                .append(System.lineSeparator());
                        count++;
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
