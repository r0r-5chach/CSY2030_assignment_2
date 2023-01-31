package org.r0r5chach.r6;

import java.util.Arrays;

import org.r0r5chach.Competitor;
import org.r0r5chach.Name;
import org.r0r5chach.Rank;

public class R6Player extends Competitor{
    private R6Attacker favoriteAttacker;
    private R6Defender favoriteDefender;

    public R6Player(int playerNumber, Name playerName, Rank playerLevel, R6Attacker favoriteAttacker, R6Defender favoriteDefender, int[] scores) {
        super(playerNumber, playerName, playerLevel, scores);
        this.favoriteAttacker = favoriteAttacker;
        this.favoriteDefender = favoriteDefender;
    }

    public void setFavoriteAttacker(R6Attacker favoriteAttacker) {
        this.favoriteAttacker = favoriteAttacker;
    }

    public void setFavoriteDefender(R6Defender favoriteDefender) {
        this.favoriteDefender = favoriteDefender;
    }

    public R6Attacker getFavoriteAttacker() {
        return this.favoriteAttacker;
    }

    public R6Defender getFavoriteDefender() {
        return this.favoriteDefender;
    }

    public String getFullDetails() {
        return "Player Number: " + getPlayerNumber() +
                "\nName: " + getPlayerName().getFullName() +
                "\nPlayer Level: " + getPlayerLevel().getRank() +
                "\nFavorite Attacker: " + getFavoriteAttacker().getAttacker() +
                "\nFavorite Attacker: " + getFavoriteDefender().getDefender() +
                "\nScores: " + Arrays.toString(getScores()).replace("[","").replace("]", "") + //replace() allows the array to not be surrounded by brackets
                "\nOverall Score: " + getOverallScore();
    }
}
