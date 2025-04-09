package de.exxcellent.challenge;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A utility class for reading weather data from a CSV file.
 *
 * <p>The CSV file should have the following format (excluding the header row):
 * <ul>
 *   <li>Day (int)</li>
 *   <li>Maximum temperature (double)</li>
 *   <li>Minimum temperature (double)</li>
 * </ul>
 *
 * <p>The {@code WeatherDataReader} class reads each row of the CSV file, parses the data, and creates a {@link WeatherRecord}
 * for each row, which is added to the list returned by the {@code readWeatherData} method.
 */
public class WeatherDataReader {

    /**
     * Reads weather data from a CSV file and returns a list of {@link WeatherRecord} objects.
     *
     * <p>This method assumes the CSV file contains data with three columns: the day of the month,
     * the maximum temperature, and the minimum temperature. The first row is skipped, assuming it contains headers.
     *
     * @param fileName The name of the CSV file containing the weather data.
     * @return A list of {@link WeatherRecord} objects representing the weather data.
     * @throws IOException If an I/O error occurs while reading the file.
     * @throws CsvValidationException If the CSV file is malformed or cannot be parsed.
     */
    public static List<WeatherRecord> readWeatherData(String fileName) throws IOException, CsvValidationException {
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
}
