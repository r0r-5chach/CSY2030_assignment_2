package com.r0r5chach.valorant;

import java.util.Arrays;

import com.r0r5chach.Competitor;
import com.r0r5chach.Name;
import com.r0r5chach.Rank;
/**
 * Class that defines the various attributes and methods associated with a Valorant Player
 * @author r0r5chach
 */
public class ValorantPlayer extends Competitor {
    private ValorantAgent favoriteAgent;
    /**
     * Constructs an object with attributes matching the parameters passed
     * @param playerNumber the number of the player
     * @param playerName the name of the player
     * @param playerLevel the level of the player
     * @param favoriteAgent the character the player plays most
     */
    public ValorantPlayer(int playerNumber, Name playerName, Rank playerLevel, ValorantAgent favoriteAgent, int[] scores) {
        super(playerNumber, playerName, playerLevel, scores);
        this.favoriteAgent = favoriteAgent;
    }
    /**
     * Set the player's most played character to that of the parameter
     * @param favoriteAgent the new most played character of the player
     */
    public void setFavoriteAgent(ValorantAgent favoriteAgent) {
        this.favoriteAgent = favoriteAgent;
    }
    /**
     * Get the player's most played character
     * @return the player's most played character
     */
    public ValorantAgent getFavoriteAgent() {
        return this.favoriteAgent;
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
                "\nFavorite Agent: " + getFavoriteAgent().getAgent();
    }
}
