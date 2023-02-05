package com.r0r5chach;

import java.util.Arrays;

import com.r0r5chach.competitor.Name;
import com.r0r5chach.competitor.Rank;
import com.r0r5chach.competitor.r6.R6Attacker;
import com.r0r5chach.competitor.r6.R6Defender;
import com.r0r5chach.competitor.valorant.ValorantAgent;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 * Class that defines the various attributes and methods associated with a Competitor Row for Table Views
 * @author r0r5chach
 */
public class CompetitorRow {
    /**
     * Attribute that stores the player's number as a property
     */
    private SimpleIntegerProperty playerNumber;
    /**
     * Attribute that stores the player's name as a property
     */
    private SimpleStringProperty playerName;
    /**
     * Attribute that stores the player's level as a property
     */
    private SimpleObjectProperty<Rank> playerLevel;
    /**
     * Attribute that stores the player's scores as a property
     */
    private SimpleStringProperty scores;
    /**
     * Attribute that stores the player's favorite agent as a property
     */
    private SimpleStringProperty favoriteAgent;
    /**
     * Attribute that stores the player's favorite attacker as a property
     */
    private SimpleStringProperty favoriteAttacker;
    /**
     * Attribute that stores the player's favorite defender as a property
     */
    private SimpleStringProperty favoriteDefender;
    /**
     * Constructs a CompetitorRow Object with the specified attributes
     * Sets favorite characters to "N/A" as none are specified
     * @param playerNumber the player's number
     * @param playerName the player's name
     * @param playerLevel the player's level
     * @param scores the player's scores
     */
    public CompetitorRow(int playerNumber, Name playerName, Rank playerLevel, int[] scores) {
        this.playerNumber = new SimpleIntegerProperty(playerNumber);
        this.playerName = new SimpleStringProperty(playerName.getFullName());
        this.playerLevel = new SimpleObjectProperty<Rank>(playerLevel);
        this.scores = new SimpleStringProperty(Arrays.toString(scores).replace("[", "").replace("]", ""));
        favoriteAgent = new SimpleStringProperty("N/A");
        favoriteAttacker = new SimpleStringProperty("N/A");
        favoriteDefender = new SimpleStringProperty("N/A");
    }
    /**
     * Constructs a CompetitorRow Object with the specified attributes
     * Sets favorite attacker and defender to "N/A" as none are specified
     * @param playerNumber the player's number
     * @param playerName the player's name
     * @param playerLevel the player's level
     * @param scores the player's scores
     * @param favoriteAgent the player's favorite agent
     */
    public CompetitorRow(int playerNumber, Name playerName, Rank playerLevel, int[] scores, ValorantAgent favoriteAgent) {
        this.playerNumber = new SimpleIntegerProperty(playerNumber);
        this.playerName = new SimpleStringProperty(playerName.getFullName());
        this.scores = new SimpleStringProperty(Arrays.toString(scores).replace("[", "").replace("]", ""));
        this.playerLevel = new SimpleObjectProperty<Rank>(playerLevel);
        this.favoriteAgent = new SimpleStringProperty(favoriteAgent.getAgent());
        favoriteAttacker = new SimpleStringProperty("N/A");
        favoriteDefender = new SimpleStringProperty("N/A");
    }
    /**
     * Constructs a CompetitorRow Object with the specified attributes
     * Sets favorite agent to "N/A" as none are specified
     * @param playerNumber the player's number
     * @param playerName the player's name
     * @param playerLevel the player's level
     * @param scores the player's scores
     * @param favoriteAttacker the player's favorite attacker
     * @param favoriteDefender the player's favorite defender
     */
    public CompetitorRow(int playerNumber, Name playerName, Rank playerLevel, int[] scores, R6Attacker favoriteAttacker, R6Defender favoriteDefender) {
        this.playerName = new SimpleStringProperty(playerName.getFullName());
        this.playerNumber = new SimpleIntegerProperty(playerNumber);
        this.scores = new SimpleStringProperty(Arrays.toString(scores).replace("[", "").replace("]", ""));
        this.playerLevel = new SimpleObjectProperty<Rank>(playerLevel);
        favoriteAgent = new SimpleStringProperty("N/A");
        this.favoriteAttacker = new SimpleStringProperty(favoriteAttacker.getAttacker());
        this.favoriteDefender = new SimpleStringProperty(favoriteDefender.getDefender());
    }
    /**
     * Get the player's number
     * @return the player's number
     */
    public int getPlayerNumber() {
        return playerNumber.get();
    }
    /**
     * Get the player's name
     * @return the player's name
     */
    public String getPlayerName() {
        return playerName.get();
    }
    /**
     * Get the player's level
     * @return the player's level
     */
    public Rank getPlayerLevel() {
        return playerLevel.get();
    }
    /**
     * Get the player's scores
     * @return the player's scores
     */
    public String getScores() {
        return scores.get();
    }
    /**
     * Get the player's favorite agent
     * @return the player's favorite agent
     */
    public String getFavoriteAgent() {
        return favoriteAgent.get();
    }
    /**
     * Get the player's favorite attacker
     * @return the player's favorite attacker
     */
    public String getFavoriteAttacker() {
        return favoriteAttacker.get();
    }
    /**
     * Get the player's favorite defender
     * @return the player's favorite defender
     */
    public String getFavoriteDefender() {
        return favoriteDefender.get();
    }    
}