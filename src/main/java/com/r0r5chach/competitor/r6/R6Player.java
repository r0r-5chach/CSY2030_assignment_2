package com.r0r5chach.competitor.r6;

import java.util.Arrays;

import com.r0r5chach.competitor.Competitor;
import com.r0r5chach.competitor.Name;
import com.r0r5chach.competitor.Rank;
/**
 * Class that defines the various attributes and methods associated with a R6 Player
 * Inherits from the com.r0r5chach.competitor.Competitor Class
 * @author r0r5chach
 */
public class R6Player extends Competitor{
    /**
     * Attribute that stores the player's favorite Attacker
     */
    private R6Attacker favoriteAttacker;
    /**
     * Attribute that stores the player's favorite Defender
     */
    private R6Defender favoriteDefender;
    /**
     * Constructs an R6Player object with attributes matching the parameters passed
     * @param playerNumber the number of the player
     * @param playerName the name of the player
     * @param playerLevel the level of the player
     * @param favoriteAttacker the attacker the player plays most
     * @param favoriteDefender the defender the player plays most
     * @param scores an array containing the 6 scores the player has achieved
     */
    public R6Player(int playerNumber, Name playerName, Rank playerLevel, R6Attacker favoriteAttacker, R6Defender favoriteDefender, int[] scores) {
        super(playerNumber, playerName, playerLevel, scores);
        this.favoriteAttacker = favoriteAttacker;
        this.favoriteDefender = favoriteDefender;
    }
    /**
     * Set the player's most played attacker to that of the parameter
     * @param favoriteAttacker the new most played attacker of the player
     */
    public void setFavoriteAttacker(R6Attacker favoriteAttacker) {
        this.favoriteAttacker = favoriteAttacker;
    }
    /**
     * Set the player's most played defender to that of the parameter
     * @param favoriteDefender the new most played defender of the player
     */
    public void setFavoriteDefender(R6Defender favoriteDefender) {
        this.favoriteDefender = favoriteDefender;
    }
    /**
     * Get the player's most played attacker
     * @return the player's most played attack
     */
    public R6Attacker getFavoriteAttacker() {
        return this.favoriteAttacker;
    }
    /**
     * Get the player's most played defender
     * @return the player's most played defender
     */
    public R6Defender getFavoriteDefender() {
        return this.favoriteDefender;
    }
    /**
     * Get all the attributes of the player
     * @return all attributes of the player in a formatted string
     */
    public String getFullDetails() {
        return "Player Number: " + getPlayerNumber() +
                "\nName: " + getPlayerName().getFullName() +
                "\nPlayer Level: " + getPlayerLevel().getRank() +
                "\nScores: " + Arrays.toString(getScores()).replace("[","").replace("]", "") + //replace() allows the array to not be surrounded by brackets
                "\nOverall Score: " + getOverallScore() +
                "\nFavorite Attacker: " + getFavoriteAttacker().getAttacker() +
                "\nFavorite Defender: " + getFavoriteDefender().getDefender();
    }
}