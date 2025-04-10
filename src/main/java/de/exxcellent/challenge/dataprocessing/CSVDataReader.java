package de.exxcellent.challenge.dataprocessing;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import de.exxcellent.challenge.records.FootballRecord;
import de.exxcellent.challenge.records.SpreadCalculable;
import de.exxcellent.challenge.records.WeatherRecord;

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

    public static final int DAY_COLUMN = 0;
    public static final int MAX_TEMP_COLUMN = 1;
    public static final int MIN_TEMP_COLUMN = 2;

    public static final int TEAM_COLUMN = 0;
    public static final int SCORED_GOALS_COLUMN = 5;
    public static final int ALLOWED_GOALS_COLUMN = 6;

    /**
     * Reads data from a CSV file and returns a list of records of a specified type.
     * The method parses the CSV file line by line, extracting the relevant data based on the class type
     * passed as an argument and populates a list of the corresponding records.
     *
     * <p>If the provided class type is {@link WeatherRecord}, the method expects the CSV file to contain
     * temperature data for different days (day, max temperature, min temperature) in the columns [0,1,2].
      * If the provided class type is {@link FootballRecord}, the method expects the CSV file to contain
     * football data of a season (team name and goals scored/allowed) in the columns [0,5,6].
     * The header row is excluded.
     *
     * @param fileName The name of the CSV file containing the data appropriate for the specified class type.
     * @param _class The class type {@code <T>} of the record that extends {@link SpreadCalculable}.
     * @return A list of record objects of the specified class type representing the csv data.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public static <T extends SpreadCalculable> List<T> readData(String fileName, Class<T> _class) throws IOException {
        List<T> records = new ArrayList<>();

        try(CSVReader csvReader = new CSVReaderBuilder(new FileReader(fileName))
                .withSkipLines(1)
                .build()) {
            String[] line;
            while ((line = csvReader.readNext()) != null) {

                if(_class.equals(WeatherRecord.class)) {
                    int day = Integer.parseInt(line[DAY_COLUMN]);
                    double maxTemp = Double.parseDouble(line[MAX_TEMP_COLUMN]);
                    double minTemp = Double.parseDouble(line[MIN_TEMP_COLUMN]);

                    records.add(_class.cast(new WeatherRecord(day, maxTemp, minTemp)));
                }
                else if(_class.equals(FootballRecord.class)) {
                    String team = line[TEAM_COLUMN];
                    int scoredGoals = Integer.parseInt(line[SCORED_GOALS_COLUMN]);
                    int allowedGoals = Integer.parseInt(line[ALLOWED_GOALS_COLUMN]);

                    records.add(_class.cast(new FootballRecord(team, scoredGoals, allowedGoals)));
                }
            }
        } catch (CsvValidationException e) {
            System.err.println("Error parsing the records file (invalid CSV data or structure): " + e.getMessage());
        }
        return records;
    }
}
