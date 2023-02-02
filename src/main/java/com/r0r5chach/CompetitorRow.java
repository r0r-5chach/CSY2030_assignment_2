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

public class CompetitorRow {
    private SimpleIntegerProperty playerNumber;
    private SimpleStringProperty playerName;
    private SimpleObjectProperty<Rank> playerLevel;
    private SimpleStringProperty scores;
    private SimpleStringProperty favoriteAgent;
    private SimpleStringProperty favoriteAttacker;
    private SimpleStringProperty favoriteDefender;

    public CompetitorRow(int playerNumber, Name playerName, Rank playerLevel, int[] scores) {
        this.playerNumber = new SimpleIntegerProperty(playerNumber);
        this.playerName = new SimpleStringProperty(playerName.getFullName());
        this.playerLevel = new SimpleObjectProperty<Rank>(playerLevel);
        this.scores = new SimpleStringProperty(Arrays.toString(scores).replace("[", "").replace("]", ""));
        favoriteAgent = new SimpleStringProperty("N/A");
        favoriteAttacker = new SimpleStringProperty("N/A");
        favoriteDefender = new SimpleStringProperty("N/A");
    }

    public CompetitorRow(int playerNumber, Name playerName, Rank playerLevel, int[] scores, ValorantAgent favoriteAgent) {
        this.playerNumber = new SimpleIntegerProperty(playerNumber);
        this.playerName = new SimpleStringProperty(playerName.getFullName());
        this.scores = new SimpleStringProperty(Arrays.toString(scores).replace("[", "").replace("]", ""));
        this.playerLevel = new SimpleObjectProperty<Rank>(playerLevel);
        this.favoriteAgent = new SimpleStringProperty(favoriteAgent.getAgent());
        favoriteAttacker = new SimpleStringProperty("N/A");
        favoriteDefender = new SimpleStringProperty("N/A");
    }

    public CompetitorRow(int playerNumber, Name playerName, Rank playerLevel, int[] scores, R6Attacker favoriteAttacker, R6Defender favoriteDefender) {
        this.playerName = new SimpleStringProperty(playerName.getFullName());
        this.playerNumber = new SimpleIntegerProperty(playerNumber);
        this.scores = new SimpleStringProperty(Arrays.toString(scores).replace("[", "").replace("]", ""));
        this.playerLevel = new SimpleObjectProperty<Rank>(playerLevel);
        favoriteAgent = new SimpleStringProperty("N/A");
        this.favoriteAttacker = new SimpleStringProperty(favoriteAttacker.getAttacker());
        this.favoriteDefender = new SimpleStringProperty(favoriteDefender.getDefender());
    }

    public int getPlayerNumber() {
        return playerNumber.get();
    }
    public String getPlayerName() {
        return playerName.get();
    }
    public Rank getPlayerLevel() {
        return playerLevel.get();
    }
    public String getScores() {
        return scores.get();
    }
    public String getFavoriteAgent() {
        return favoriteAgent.get();
    }
    public String getFavoriteAttacker() {
        return favoriteAttacker.get();
    }
    public String getFavoriteDefender() {
        return favoriteDefender.get();
    }    
}
