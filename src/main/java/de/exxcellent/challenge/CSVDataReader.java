package de.exxcellent.challenge;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A utility class for reading data from a CSV file.
 *
 * <p>The {@code CSVDataReader} class provides different methods to read each row of the CSV file, parse the data,
 * and create a record for each row, which is added to the returned list.
 */
public class CSVDataReader {

    /**
     * Reads weather data from a CSV file and returns a list of {@link WeatherRecord} objects.
     *
     * <p>The CSV file is expected to contain data including the three columns:
     * <ul>
     *   <li>Column 0: Day (int)</li>
     *   <li>Column 1: Maximum temperature (double)</li>
     *   <li>Column 2: Minimum temperature (double)</li>
     * </ul>
     * The header row is excluded.
     *
     * @param fileName The name of the CSV file containing the weather data.
     * @return A list of {@link WeatherRecord} objects representing the weather data.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public static List<WeatherRecord> readWeatherData(String fileName) throws IOException {
        List<WeatherRecord> records = new ArrayList<>();

        try(CSVReader csvReader = new CSVReaderBuilder(new FileReader(fileName))
                .withSkipLines(1)
                .build()) {
            String[] line;
            while ((line = csvReader.readNext()) != null) {

                int day = Integer.parseInt(line[0]);
                double maxTemp = Double.parseDouble(line[1]);
                double minTemp = Double.parseDouble(line[2]);

                records.add(new WeatherRecord(day, maxTemp, minTemp));
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return records;
    }

    /**
     * Reads football data from a CSV file and returns a list of {@link FootballRecord} objects.
     *
     * <p>The CSV file is expected to contain data including the three columns:
     * <ul>
     *   <li>Column 0: Team (String)</li>
     *   <li>Column 5: Scored Goals (int)</li>
     *   <li>Column 6: Allowed Goals (int)</li>
     * </ul>
     * The header row is excluded.
     *
     * @param fileName The name of the CSV file containing the football data.
     * @return A list of {@link FootballRecord} objects representing the football data.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public static List<FootballRecord> readFootballData(String fileName) throws IOException {
        List<FootballRecord> records = new ArrayList<>();

        try(CSVReader csvReader = new CSVReaderBuilder(new FileReader(fileName))
                .withSkipLines(1)
                .build()) {
            String[] line;
            while ((line = csvReader.readNext()) != null) {

                String team = line[0];
                int scoredGoals = Integer.parseInt(line[5]);
                int allowedGoals = Integer.parseInt(line[6]);

                records.add(new FootballRecord(team, scoredGoals, allowedGoals));
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return records;
    }
}
