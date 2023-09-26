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
                try {
                    String type = line[0].trim();
                    String name = line[1].trim();
                    if (type.length() == 0)
                        throw new ParserException("On a line number " + lineNumber + ", type cannot be empty.");
                    if (name.length() == 0)
                        throw new ParserException("On a line number " + lineNumber + ", type cannot be empty.");
                    int longitude = Integer.parseInt(line[2]);
                    int latitude = Integer.parseInt(line[3]);
                    int height = Integer.parseInt(line[4]);
                    flyableSet.add(aircraftFactory.newAircraft(type,
                            name,
                            new Coordinates(longitude,
                                    latitude,
                                    height)));
                    lineNumber++;
                } catch (NumberFormatException e) {
                    throw new ParserException("On a line number " + lineNumber + ", expected a number.");
                } catch (IllegalArgumentException e) {
                    throw new ParserException("On a line number " + lineNumber + ", " + e.getMessage());
                }
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
