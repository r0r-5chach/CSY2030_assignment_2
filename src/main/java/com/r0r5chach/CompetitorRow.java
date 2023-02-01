package com.r0r5chach;

import java.util.Arrays;

import com.r0r5chach.r6.R6Attacker;
import com.r0r5chach.r6.R6Defender;
import com.r0r5chach.valorant.ValorantAgent;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class CompetitorRow {
    private SimpleIntegerProperty playerNumber;
    private SimpleStringProperty playerName;
    private SimpleObjectProperty<Rank> playerLevel;
    private SimpleStringProperty scores;
    private SimpleObjectProperty<ValorantAgent> favoriteAgent;
    private SimpleObjectProperty<R6Attacker> favoriteAttacker;
    private SimpleObjectProperty<R6Defender> favoriteDefender;

    public CompetitorRow(int playerNumber, Name playerName, Rank playerLevel, int[] scores) {
        this.playerNumber = new SimpleIntegerProperty(playerNumber);
        this.playerName = new SimpleStringProperty(playerName.getFullName());
        this.playerLevel = new SimpleObjectProperty<Rank>(playerLevel);
        this.scores = new SimpleStringProperty(Arrays.toString(scores).replace("[", "").replace("]", ""));
        this.favoriteAgent = null;
        this.favoriteAttacker = null;
        this.favoriteDefender = null;
    }

    public CompetitorRow(int playerNumber, Name playerName, Rank playerLevel, int[] scores, ValorantAgent favoriteAgent) {
        this.playerNumber = new SimpleIntegerProperty(playerNumber);
        this.playerName = new SimpleStringProperty(playerName.getFullName());
        this.scores = new SimpleStringProperty(Arrays.toString(scores).replace("[", "").replace("]", ""));
        this.playerLevel = new SimpleObjectProperty<Rank>(playerLevel);
        this.favoriteAgent = new SimpleObjectProperty<ValorantAgent>(favoriteAgent);
        this.favoriteAttacker = null;
        this.favoriteDefender = null;
    }

    public CompetitorRow(int playerNumber, Name playerName, Rank playerLevel, int[] scores, R6Attacker favoriteAttacker, R6Defender favoriteDefender) {
        this.playerName = new SimpleStringProperty(playerName.getFullName());
        this.playerNumber = new SimpleIntegerProperty(playerNumber);
        this.scores = new SimpleStringProperty(Arrays.toString(scores).replace("[", "").replace("]", ""));
        this.playerLevel = new SimpleObjectProperty<Rank>(playerLevel);
        this.favoriteAgent = null;
        this.favoriteAttacker = new SimpleObjectProperty<R6Attacker>(favoriteAttacker);
        this.favoriteDefender = new SimpleObjectProperty<R6Defender>(favoriteDefender);
    }

    public void setPlayerNumber(int newValue) {
        this.playerNumber.set(newValue);
    }
    public void setPlayerName(String newValue) {
        this.playerName.set(newValue);
    }
    public void setPlayerLevel(Rank newValue) {
        this.playerLevel.set(newValue);
    }
    public void setScores(String newValue) {
        this.scores.set(newValue);
    }
    public void setFavoriteAgent(ValorantAgent newValue) {
        this.favoriteAgent.set(newValue);
    }
    public void setFavoriteAttacker(R6Attacker newValue) {
        this.favoriteAttacker.set(newValue);
    }
    public void setFavoriteDefender(R6Defender newValue) {
        this.favoriteDefender.set(newValue);
    }    

    public int getPlayerNumber() {
        return this.playerNumber.get();
    }
    public String getPlayerName() {
        return this.playerName.get();
    }
    public Rank getPlayerLevel() {
        return this.playerLevel.get();
    }
    public String getScores() {
        return this.scores.get();
    }
    public ValorantAgent getFavoriteAgent() {
        return this.favoriteAgent.get();
    }
    public R6Attacker getFavoriteAttacker() {
        return this.favoriteAttacker.get();
    }
    public R6Defender getFavoriteDefender() {
        return this.favoriteDefender.get();
    }    
}
