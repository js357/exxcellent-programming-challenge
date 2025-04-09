package de.exxcellent.challenge;

public record FootballRecord(String team, int scoredGoals, int allowedGoals) {

    public int getGoalDifference() {
        return Math.abs(scoredGoals - allowedGoals);
    }

}
