package de.exxcellent.challenge.records;

/**
 * Represents a weather record for a specific day of the month.
 *
 * <p>The {@code WeatherRecord} class stores information about a specific day of the month, the maximum temperature,
 * and the minimum temperature. It provides a method to calculate the difference (spread) between the maximum
 * and minimum temperatures.
 *
 * @param day The day of the month.
 * @param maxTemp The maximum temperature of the day.
 * @param minTemp The minimum temperature of the day.
 */
public record WeatherRecord(int day, double maxTemp, double minTemp) {

    /**
     * Calculates the temperature spread between the maximum and minimum temperature.
     *
     * @return The absolute difference between the maximum and minimum temperatures.
     */
    public double getTempSpread() {
        return Math.abs(maxTemp - minTemp);
    }

}
