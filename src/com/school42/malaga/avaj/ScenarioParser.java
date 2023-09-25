package com.school42.malaga.avaj;

import com.school42.malaga.avaj.aircraft.AircraftFactory;
import com.school42.malaga.avaj.aircraft.Flyable;
import com.school42.malaga.avaj.exceptions.ParserException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ScenarioParser {

    private int simulationsNumber;
    private Set<Flyable> flyableSet;

    public ScenarioParser(String filename) throws FileNotFoundException {
        AircraftFactory aircraftFactory = AircraftFactory.getInstance();
        this.flyableSet = new HashSet<>();
        try (Scanner sc = new Scanner(new File(filename))) {
            if (!sc.hasNextLine())
                throw new ParserException("File is empty.");
            if (!sc.hasNextInt())
                throw new ParserException("No simulations added.");
            this.simulationsNumber = sc.nextInt();
            if (this.simulationsNumber <= 0)
                throw new ParserException("Simulation number cannot be equal or lower to zero.");
            if (!sc.hasNextLine())
                throw new ParserException("File does not contain any aircraft.");
            sc.nextLine();
            int lineNumber = 1;
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(" ");
                if (line.length != 5)
                    throw new ParserException("Error on a line number " + lineNumber + ":\nFormat: <Type> <Identifier> <longitude> <latitude> <height>.");
                String type = line[0];
                String name = line[1];
                int longitude = Integer.parseInt(line[2]);
                int latitude = Integer.parseInt(line[3]);
                int height = Integer.parseInt(line[4]);
                try {
                    flyableSet.add(aircraftFactory.newAircraft(type,
                            name,
                            new Coordinates(longitude,
                                    latitude,
                                    height)));
                } catch (IllegalArgumentException e) {
                    throw new ParserException("Error on a line number " + lineNumber + ":\n" + e.getMessage());
                }
                lineNumber++;
            }
            if (flyableSet.size() == 0)
                throw new ParserException("Could not find any aircraft line.");
        }
    }

    public Set<Flyable> getFlyableSet() {
        return flyableSet;
    }

    public int getSimulationsNumber() {
        return simulationsNumber;
    }
}
