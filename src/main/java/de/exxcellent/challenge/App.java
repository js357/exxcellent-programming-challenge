package de.exxcellent.challenge;

import com.opencsv.exceptions.CsvValidationException;

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
            List<WeatherRecord> records = WeatherDataReader.readWeatherData("src/main/resources/de/exxcellent/challenge/weather.csv");
            int dayWithSmallestTempSpread = WeatherAnalyzer.findDayWithSmallestTempSpread(records);
            System.out.printf("Day with smallest temperature spread : %d%n", dayWithSmallestTempSpread);

            String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
            System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);

        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
