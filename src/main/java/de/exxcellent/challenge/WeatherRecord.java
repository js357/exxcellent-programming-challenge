package de.exxcellent.challenge;

public record WeatherRecord(int day, double maxTemp, double minTemp) {

    public double getTempSpread() {
        return Math.abs(maxTemp - minTemp);
    }

}
