package de.exxcellent.challenge.records;

/**
 * Represents a weather record for a specific day of the month.
 *
 * <p>The {@code WeatherRecord} class stores information about a specific day of the month, the maximum temperature,
 * and the minimum temperature.
 * This class implements the {@link SpreadCalculable} interface.
 * It provides a method for calculating the absolute difference (spread) between the maximum and minimum temperatures.
 */
public record WeatherRecord(int day, double maxTemp, double minTemp) implements SpreadCalculable {

    /**
     * Calculates the temperature spread between the maximum and minimum temperature.
     *
     * @return The absolute difference between the maximum and minimum temperatures.
     */
    @Override
    public double getSpread() {
        return Math.abs(maxTemp - minTemp);
    }

}
