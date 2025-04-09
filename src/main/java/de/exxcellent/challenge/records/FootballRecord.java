package de.exxcellent.challenge.records;

/**
 * Represents the record of a football team over a season.
 *
 * <p>The {@code FootballRecord} class stores the team name, the number of goals scored by the team,
 * and the number of goals allowed by the team over the season.
 * This class extends {@link BaseRecord} and implements the {@link SpreadCalculable} interface.
 * It provides a method for calculating the absolute goal difference (spread) between the goals scored and allowed.
 */
public class FootballRecord extends BaseRecord{

    private final String team;
    private final int scoredGoals;
    private final int allowedGoals;

    /**
     * Constructs a {@link FootballRecord} with the given team name, goals scored, and goals allowed.
     *
     * @param team The name of the football team.
     * @param scoredGoals The number of goals scored by the team.
     * @param allowedGoals The number of goals allowed by the team.
     */
    public FootballRecord(String team, int scoredGoals, int allowedGoals) {
        this.team = team;
        this.scoredGoals = scoredGoals;
        this.allowedGoals = allowedGoals;
    }

    /**
     * Gets the name of the football team associated with this record.
     *
     * @return The name of the football team as a {@code String}.
     */
    public String getTeam() {
        return team;
    }

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
