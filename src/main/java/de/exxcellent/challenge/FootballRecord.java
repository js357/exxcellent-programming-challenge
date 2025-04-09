package de.exxcellent.challenge;

/**
 * Represents statistics of football matches for a specific team.
 *
 * <p>The {@code FootballRecord} record stores the team name, the number of goals scored by the team,
 * and the number of goals allowed by the team in a match. It also provides a method to calculate the
 * goal difference between scored and allowed goals.
 *
 * @param team The name of the team.
 * @param scoredGoals The number of goals scored by the team.
 * @param allowedGoals The number of goals allowed by the team.
 */
public record FootballRecord(String team, int scoredGoals, int allowedGoals) {

    /**
     * Calculates the absolute goal difference between scored and allowed goals.
     *
     * @return The absolute goal difference between the scored and allowed goals.
     */
    public int getGoalDifference() {
        return Math.abs(scoredGoals - allowedGoals);
    }

}
