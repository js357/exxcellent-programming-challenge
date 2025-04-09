package de.exxcellent.challenge;

import java.util.List;

public class WeatherAnalyzer {

    public static int findDayWithSmallestTempSpread(List<WeatherRecord> records) {
        WeatherRecord dayWithSmallestSpread = null;
        double smallestTempSpread = Double.MAX_VALUE;

        for (WeatherRecord record : records) {
            double spread = record.getTempSpread();
            if (spread < smallestTempSpread) {
                smallestTempSpread = spread;
                dayWithSmallestSpread = record;
            }
        }
        return dayWithSmallestSpread != null ? dayWithSmallestSpread.getDay() : -1;
    }
}
