package de.exxcellent.challenge.records;

/**
 * Represents the record of a football team over a season.
 *
 * <p>The {@code FootballRecord} class stores the team name, the number of goals scored by the team,
 * and the number of goals allowed by the team over the season.
 * This class implements the {@link SpreadCalculable} interface.
 * It provides a method for calculating the absolute goal difference (spread) between the goals scored and allowed.
 */
public record FootballRecord(String team, int scoredGoals, int allowedGoals) implements SpreadCalculable {

    /**
     * Calculates the absolute goal difference between scored and allowed goals.
     *
     * @return The absolute goal difference between the scored and allowed goals.
     */
    @Override
    public double getSpread() {
        return Math.abs(scoredGoals - allowedGoals);
    }
}
