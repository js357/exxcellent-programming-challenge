package de.exxcellent.challenge.dataprocessing;

import de.exxcellent.challenge.records.FootballRecord;
import de.exxcellent.challenge.records.WeatherRecord;

import java.util.List;

/**
 * A utility class for analyzing data.
 *
 * <p>The {@code DataAnalyzer} class provides methods to perform various analyses on records.
 */
public class DataAnalyzer {

    /**
     * Finds the day with the smallest temperature spread.
     *
     * <p>The temperature spread (difference between maximum and minimum temperatures) for each day
     * is calculated using the {@link WeatherRecord#getTempSpread()} method.
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

    /**
     * Finds the team with the smallest goal difference.
     *
     * <p>The goal difference (scored goals minus allowed goals) is calculated using
     * the {@link FootballRecord#getGoalDifference()} method.
     * The team with the smallest difference is returned. If no records are provided, the method returns null.
     *
     * @param footballRecords A list of {@link FootballRecord} objects containing the football data for different teams.
     * @return The name of the team with the smallest goal difference, or {@code null} if the list is empty.
     */
    public static String findTeamWithSmallestGoalSpread(List<FootballRecord> footballRecords) {
        FootballRecord teamWithSmallestGoalSpread = null;
        double smallestGoalDiff = Integer.MAX_VALUE;

        for (FootballRecord footballRecord : footballRecords) {
            double spread = footballRecord.getGoalDifference();
            if (spread < smallestGoalDiff) {
                smallestGoalDiff = spread;
                teamWithSmallestGoalSpread = footballRecord;
            }
        }
        return teamWithSmallestGoalSpread != null ? teamWithSmallestGoalSpread.team() : null;
    }
}