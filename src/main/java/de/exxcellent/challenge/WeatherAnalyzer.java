package de.exxcellent.challenge;

import java.util.List;

/**
 * A utility class for analyzing weather data.
 * This class provides methods to perform various analyses on weather records.
 *
 * <p>The {@code WeatherAnalyzer} class can be used to find specific weather patterns,
 * such as the day with the smallest temperature spread, using a list of {@link WeatherRecord} objects.
 */
public class WeatherAnalyzer {

    /**
     * Finds the day with the smallest temperature spread (difference between maximum and minimum temperatures).
     *
     * <p>The temperature spread for each day is calculated using the {@link WeatherRecord#getTempSpread()} method.
     * The day with the smallest spread is returned. If no records are provided, the method returns -1.
     *
     * @param weatherRecords A list of {@link WeatherRecord} objects containing the weather data.
     * @return The day with the smallest temperature spread, or -1 if no valid records are provided.
     */
    public static int findDayWithSmallestTempSpread(List<WeatherRecord> weatherRecords) {
        WeatherRecord dayWithSmallestSpread = null;
        double smallestTempSpread = Double.MAX_VALUE;

        for (WeatherRecord weatherRecord : weatherRecords) {
            double spread = weatherRecord.getTempSpread();
            if (spread < smallestTempSpread) {
                smallestTempSpread = spread;
                dayWithSmallestSpread = weatherRecord;
            }
        }
        return dayWithSmallestSpread != null ? dayWithSmallestSpread.day() : -1;
    }
}
