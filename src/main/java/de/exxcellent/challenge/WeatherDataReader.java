package de.exxcellent.challenge;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WeatherDataReader {

    public static List<WeatherRecord> readWeatherData(String fileName) throws IOException{
        List<WeatherRecord> records = new ArrayList<WeatherRecord>();

        try(CSVReader csvReader = new CSVReaderBuilder(new FileReader(fileName))
                .withSkipLines(1)
                .build()) {
            String[] line = null;
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
