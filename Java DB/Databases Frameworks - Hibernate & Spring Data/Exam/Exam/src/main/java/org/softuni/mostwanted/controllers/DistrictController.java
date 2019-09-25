package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.domain.dtos.json.DistrictJSONImportDto;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.interfaces.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class DistrictController {
    private final DistrictService districtService;
    private final Parser parser;

    @Autowired
    public DistrictController(DistrictService districtService,
                         @Qualifier("JSONParser") Parser parser) {
        this.districtService = districtService;
        this.parser = parser;
    }

    public String importDataFromJSON(String jsonContent) {
        StringBuilder sb = new StringBuilder();
        try {
            DistrictJSONImportDto[] districts = parser.read(DistrictJSONImportDto[].class, jsonContent);
            Arrays.stream(districts).forEach(a -> {
                boolean hasInvalidData = false;
                if (ValidationUtil.isValid(a)) {
                    try {
                        this.districtService.create(a);
                    } catch (IllegalArgumentException e) {
                        hasInvalidData = true;
                    }
                    if (hasInvalidData) {
                        sb.append("Error: Invalid data.").append(System.lineSeparator());
                    } else {
                        sb.append(String.format("Successfully imported District - %s.", a.getName()))
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
