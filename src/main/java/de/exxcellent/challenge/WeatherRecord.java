package de.exxcellent.challenge;

public class WeatherRecord {
    private final int day;
    private final double maxTemp;
    private final double minTemp;


    public WeatherRecord(int day, double maxTemp, double minTemp) {
        this.day = day;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    public int getDay() {
        return day;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getTempSpread() {
        return Math.abs(maxTemp - minTemp);
    }

}
