package com.r0r5chach.competitor;

import java.text.DecimalFormat;
/**
 * Class that defines the various attributes and methods associated with a Competitor
 * @author r0r5chach
 */
public abstract class Competitor {
    /**
     * The format to use when converting decimal numbers to strings
     */
    protected static final DecimalFormat df = new DecimalFormat("0.00");
    /**
     * The number of the player in the competition
     */
    protected int playerNumber;
    /**
     * The name of the player in the competition
     */
    protected Name playerName;
    /**
     * The level the player plays at in the competition
     * These are derived from the first 4 ranks of the normal game
     */
    protected Rank playerLevel;
    /**
     * The scores the player has received
     */
    protected int[] scores;
    /**
     * Constructs an object with attributes matching the parameters passed
     * @param playerNumber the number of the player
     * @param playerName the name of the player
     * @param playerLevel the level of the player
     * @param scores an array containing the 6 scores the player has achieved
     */
    public Competitor(int playerNumber, Name playerName, Rank playerLevel, int[] scores) {
        this.playerNumber = playerNumber;
        this.playerName = playerName;
        this.playerLevel = playerLevel;
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
    public void setPlayerLevel(Rank playerLevel) {
        this.playerLevel = playerLevel;
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
    public Rank getPlayerLevel() {
        return this.playerLevel;
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
            if (Math.log(score) != Double.NEGATIVE_INFINITY) {
                output += Math.log(score); //get the sum of the natural log of the scores
            }
        }
        output /= 1.93; //divide the sum by 1.93
        
        return Double.parseDouble(df.format(output)); //df.format() allows the scores to be formatted to 2 decimal places
    }
    /**
     * Get all the attributes of the player
     * @return all attributes of the player in a formatted string
     */
    public abstract String getFullDetails();
    /**
     * Get the important attributes of the player
     * @return a formatted string containing the playerNumber, playerName, and overall score
     */
    public String getShortDetails() {
        return "CN " + getPlayerNumber() + " (" + getPlayerName().getInitials() + ") has overall score " + getOverallScore();
    }
}