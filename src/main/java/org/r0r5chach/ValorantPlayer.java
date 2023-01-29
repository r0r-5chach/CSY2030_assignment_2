package org.r0r5chach;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Class that defines the various attributes and methods associated with a Valorant Player
 * @author r0r5chach
 */
public class ValorantPlayer {
    /**
     * The format to use when converting decimal numbers to strings
     */
    private static final DecimalFormat df = new DecimalFormat("0.00");
    /**
     * The number of the player in the competition
     */
    private int playerNumber;
    /**
     * The name of the player in the competition
     */
    private Name playerName;
    /**
     * The level the player plays at in the competition
     * These are derived from the first 4 ranks of the normal game
     */
    private ValorantRank playerLevel;
    /**
     * The character the player plays the most
     */
    private ValorantAgent favouriteAgent;
    /**
     * The scores the player has received
     */
    private int[] scores;
    /**
     * Constructs an object with attributes matching the parameters passed
     * @param playerNumber the number of the player
     * @param playerName the name of the player
     * @param playerLevel the level of the player
     * @param favouriteAgent the character the player plays most
     */
    public ValorantPlayer(int playerNumber, Name playerName, ValorantRank playerLevel, ValorantAgent favouriteAgent, int[] scores) {
        this.playerNumber = playerNumber;
        this.playerName = playerName;
        this.playerLevel = playerLevel;
        this.favouriteAgent = favouriteAgent;
        this.scores = scores;
    }
    /**
     * Set the player's number to that of the parameter
     * @param playerNumber the new number of the player
     */
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }
    /**
     * Set the player's name to that of the parameter
     * @param playerName the new name of the player
     */
    public void setPlayerName(Name playerName) {
        this.playerName = playerName;
    }
    /**
     * Set the player's level to that of the parameter
     * @param playerLevel the new level of the player
     */
    public void setPlayerLevel(ValorantRank playerLevel) {
        this.playerLevel = playerLevel;
    }
    /**
     * Set the player's most played character to that of the parameter
     * @param favouriteAgent the new most played character of the player
     */
    public void setFavouriteAgent(ValorantAgent favouriteAgent) {
        this.favouriteAgent = favouriteAgent;
    }
    /**
     * Set the player's scores
     * @param scores the new scores for the player
     */
    public void setScores(int[] scores) {
        this.scores = scores;
    }
    /**
     * Get the player's number
     * @return the player's number
     */
    public int getPlayerNumber() {
        return this.playerNumber;
    }
    /**
     * Get the player's name
     * @return the player's name
     */
    public Name getPlayerName() {
        return this.playerName;
    }
    /**
     * Get the player's level
     * @return the player's level
     */
    public ValorantRank getPlayerLevel() {
        return this.playerLevel;
    }
    /**
     * Get the player's most played character
     * @return the player's most played character
     */
    public ValorantAgent getFavouriteAgent() {
        return this.favouriteAgent;
    }
    /**
     * Get the player's scores
     * @return an array containing the scores
     */
    public int[] getScores() {
        return this.scores;
    }
    /**
     * Calculates and then returns the overall score of the player.
     * The score is calculated by taking the natural log of each score and then dividing the sum by 1.93
     * @return an aggregate of the individual scores the player has achieved
     */
    public double getOverallScore() {
        double output = 0;
        for (int score: getScores()) {
            output += Math.log(score); //get the sum of the natural log of the scores
        }
        output /= 1.93; //divide the sum by 1.93
        if (output == Double.NEGATIVE_INFINITY) {
            output = 0;
        }
        return Double.parseDouble(df.format(output)); //df.format() allows the scores to be formatted to 2 decimal places
    }
    /**
     * Get all the attributes of the player
     * @return all attributes of the player in a formatted string
     */
    public String getFullDetails() {
        return "Player Number: " + getPlayerNumber() +
                "\nName: " + getPlayerName().getFullName() +
                "\nPlayer Level: " + getPlayerLevel().getRank() +
                "\nFavourite Agent: " + getFavouriteAgent().getAgent() +
                "\nScores: " + Arrays.toString(getScores()).replace("[","").replace("]", "") + //replace() allows the array to not be surrounded by brackets
                "\nOverall Score: " + getOverallScore();
    }
    /**
     * Get the important attributes of the player
     * @return a formatted string containing the playerNumber, playerName, and overall score
     */
    public String getShortDetails() {
        return "CN " + getPlayerNumber() + " (" + getPlayerName().getInitials() + ") has overall score " + getOverallScore();
    }
}
