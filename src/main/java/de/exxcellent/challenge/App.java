package de.exxcellent.challenge;

import de.exxcellent.challenge.dataprocessing.CSVDataReader;
import de.exxcellent.challenge.dataprocessing.DataAnalyzer;
import de.exxcellent.challenge.records.FootballRecord;
import de.exxcellent.challenge.records.WeatherRecord;

import java.io.IOException;
import java.util.List;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        String weatherDataPath = "src/main/resources/de/exxcellent/challenge/weather.csv";
        String footballDataPath = "src/main/resources/de/exxcellent/challenge/football.csv";

        try {
            // Weather challenge
            List<WeatherRecord> weatherRecords = CSVDataReader.readData(weatherDataPath, WeatherRecord.class);
            String dayWithSmallestTempSpread = DataAnalyzer.findDataWithSmallestSpread(weatherRecords);
            System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        } catch (IOException e) {
            System.err.println("Error reading the weather file: " + e.getMessage());
        }

        try{
            // Football challenge
            List<FootballRecord> footballRecords = CSVDataReader.readData(footballDataPath, FootballRecord.class);
            String teamWithSmallestGoalSpread = DataAnalyzer.findDataWithSmallestSpread(footballRecords);
            System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);

        } catch (IOException e) {
            System.err.println("Error reading the football file: " + e.getMessage());
        }
    }
}
