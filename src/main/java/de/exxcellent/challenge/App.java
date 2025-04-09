package de.exxcellent.challenge;

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

        try {
            List<WeatherRecord> weatherRecords = CSVDataReader.readWeatherData("src/main/resources/de/exxcellent/challenge/weather.csv");
            int dayWithSmallestTempSpread = DataAnalyzer.findDayWithSmallestTempSpread(weatherRecords);
            System.out.printf("Day with smallest temperature spread : %d%n", dayWithSmallestTempSpread);

            List<FootballRecord> footballRecords = CSVDataReader.readFootballData("src/main/resources/de/exxcellent/challenge/football.csv");
            String teamWithSmallestGoalSpread = DataAnalyzer.findTeamWithSmallestGoalSpread(footballRecords);
            System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
