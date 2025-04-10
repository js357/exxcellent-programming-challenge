package de.exxcellent.challenge.dataprocessing;

import de.exxcellent.challenge.records.FootballRecord;
import de.exxcellent.challenge.records.SpreadCalculable;
import de.exxcellent.challenge.records.WeatherRecord;

import java.util.List;

/**
 * A utility class for analyzing data.
 *
 * <p>The {@code DataAnalyzer} class provides methods for processing collections of data and determining
 * specific attributes.
 */
public class DataAnalyzer {

    /**
     * Finds the data with the smallest spread (difference between maximum and minimum) from a list of records.
     * The method calculates the spread (using the {@link SpreadCalculable#getSpread()} method) for each record
     * and identifies the record with the smallest spread.
     *
     * @param records A list of {@link SpreadCalculable} objects.
     * @param <T> The type of records in the list, which extends {@link SpreadCalculable}.
     * @return A string representing the day with the smallest temperature spread if the records are
     *         instances of {@link WeatherRecord}, or the team name for {@link FootballRecord}.
     *         Returns {@code null} if no valid records are provided or no smallest spread is found.
     */
    public static <T extends SpreadCalculable> String findDataWithSmallestSpread(List<T> records) {
        T elementWithSmallestSpread = null;
        double smallestSpread = Double.MAX_VALUE;

        for (T record : records) {
            double spread = record.getSpread();
            if (spread < smallestSpread) {
                smallestSpread = spread;
                elementWithSmallestSpread = record;
            }
        }

        if (elementWithSmallestSpread instanceof WeatherRecord) {
            return String.valueOf(((WeatherRecord) elementWithSmallestSpread).day());
        } else if (elementWithSmallestSpread instanceof FootballRecord) {
            return ((FootballRecord) elementWithSmallestSpread).team();
        }
        return null;
    }

}