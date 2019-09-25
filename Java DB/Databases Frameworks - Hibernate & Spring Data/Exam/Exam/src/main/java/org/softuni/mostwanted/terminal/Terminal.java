package org.softuni.mostwanted.terminal;

import org.softuni.mostwanted.config.Config;
import org.softuni.mostwanted.controllers.*;
import org.softuni.mostwanted.io.interfaces.ConsoleIO;
import org.softuni.mostwanted.io.interfaces.FileIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class Terminal implements CommandLineRunner {
    private final CarController carController;
    private final DistrictController districtController;
    private final RaceController raceController;
    private final RaceEntryController raceEntryController;
    private final RacerController racerController;
    private final TownController townController;
    private final FileIO fileIO;
    private final ConsoleIO consoleIO;

    @Autowired
    public Terminal(CarController carController, DistrictController districtController, RaceController raceController, RaceEntryController raceEntryController, RacerController racerController, TownController townController, FileIO fileIO, ConsoleIO consoleIO) {
        this.carController = carController;
        this.districtController = districtController;
        this.raceController = raceController;
        this.raceEntryController = raceEntryController;
        this.racerController = racerController;
        this.townController = townController;
        this.fileIO = fileIO;
        this.consoleIO = consoleIO;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.consoleIO.write(this.townController
                .importDataFromJSON(
                        this.fileIO
                                .read(Config.TOWNS_IMPORT_JSON)));

        this.consoleIO.write(this.districtController
                .importDataFromJSON(
                        this.fileIO
                                .read(Config.DISTRICTS_IMPORT_JSON)));

        this.consoleIO.write(this.racerController
                .importDataFromJSON(
                        this.fileIO
                                .read(Config.RACERS_IMPORT_JSON)));


        this.consoleIO.write(this.carController
                .importDataFromJSON(
                        this.fileIO
                                .read(Config.CARS_IMPORT_JSON)));


        this.consoleIO.write(this.raceEntryController
                .importDataFromXML(
                        this.fileIO
                                .read(Config.RACE_ENTRIES_IMPORT_XML)));
        this.consoleIO.write(this.raceController
                .importDataFromXML(
                        this.fileIO
                                .read(Config.RACES_IMPORT_XML)));


    }
}
