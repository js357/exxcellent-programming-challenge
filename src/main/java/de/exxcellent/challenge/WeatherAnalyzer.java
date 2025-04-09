package de.exxcellent.challenge;

import java.util.List;

public class WeatherAnalyzer {

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
