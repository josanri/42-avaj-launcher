package com.school42.malaga.avaj;

import com.school42.malaga.avaj.exceptions.ParserException;
import com.school42.malaga.avaj.tower.WeatherTower;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Simulator {
    public static void main(String[] args) {
        checkArguments(args);
        String filename = args[0];
        PrintStream originalStdout = System.out;
        try (SimulatorWriter simulatorWriter = new SimulatorWriter()){
            System.setOut(simulatorWriter.getStream());
            ScenarioParser parser = new ScenarioParser(filename);
            WeatherTower weatherTower = new WeatherTower();
            parser.getFlyableSet().forEach(flyable -> flyable.registerTower(weatherTower));
            for (int i = 0; i < parser.getSimulationsNumber(); i++) {
                weatherTower.changeWeather();
            }
        } catch (FileNotFoundException e) {
            handleSimulationException(originalStdout, "Error: File '" + filename + "' could not be found");
        } catch (ParserException e) {
            handleSimulationException(originalStdout, "Error while parsing: " + e.getMessage());
        } catch (Exception e) {
            handleSimulationException(originalStdout, "Error: " + e);
        }
    }

    private static void checkArguments(String[] args) {
        if (args.length != 1) {
            System.out.println("Error: Incorrect number of arguments");
            System.out.println("usage: java Simulator <filename>");
            System.exit(1);
        }
    }

    private static void handleSimulationException(PrintStream originalStdout, String args) {
        System.setOut(originalStdout);
        System.out.println(args);
        System.exit(1);
    }
}
