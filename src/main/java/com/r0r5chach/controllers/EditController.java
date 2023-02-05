package com.r0r5chach.controllers;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import com.r0r5chach.competitor.Competitor;
import com.r0r5chach.competitor.Name;
import com.r0r5chach.competitor.Rank;
import com.r0r5chach.competitor.r6.R6Attacker;
import com.r0r5chach.competitor.r6.R6Defender;
import com.r0r5chach.competitor.r6.R6Player;
import com.r0r5chach.competitor.valorant.ValorantAgent;
import com.r0r5chach.competitor.valorant.ValorantPlayer;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
/**
 * Class that defines the controller for the edit View (edit.fxml) of the GUI
 * Inherits from com.r0r5chach.controllers.Controller
 */
public class EditController extends Controller {
    /**
     * Attribute that stores the competitor list for the edit View
     */
    @FXML
    private ListView<Integer> competitorsList;
    /**
     * Attribute that stores the selected player's number for the edit View
     */
    @FXML
    private TextField playerNumber;
    /**
     * Attribute that stores the selected player's name for the edit View
     */
    @FXML
    private TextField playerName;
    /**
     * Attribute that stores the selected player's level for the edit View
     */
    @FXML
    private ChoiceBox<Rank> playerLevel;
    /**
     * Attribute that stores the selected player's favorite character identifier for the edit View
     */
    @FXML
    private Text favoriteCharacters;
    /**
     * Attribute that stores the selected player's favorite attacker for the edit View
     */
    @FXML
    private ChoiceBox<R6Attacker> favoriteAttacker;
    /**
     * Attribute that stores the selected player's favorite agent for the edit View
     */
    @FXML
    private ChoiceBox<ValorantAgent> favoriteAgent;
    /**
     * Attribute that stores the selected player's favorite defender for the edit View
     */
    @FXML
    private ChoiceBox<R6Defender> favoriteDefender;
    /**
     * Attribute that stores the selected player's first score for the edit View
     */
    @FXML
    private TextField scores0;
    /**
     * Attribute that stores the selected player's second score for the edit View
     */
    @FXML
    private TextField scores1;
    /**
     * Attribute that stores the selected player's third score for the edit View
     */
    @FXML
    private TextField scores2;
    /**
     * Attribute that stores the selected player's fourth score for the edit View
     */
    @FXML
    private TextField scores3;
    /**
     * Attribute that stores the selected player's fifth score for the edit View
     */
    @FXML
    private TextField scores4;
    /**
     * Attribute that stores the selected player's sixth score for the edit View
     */
    @FXML
    private TextField scores5;
    /**
     * Attribute that stores the selected player's overall score for the edit View
     */
    @FXML
    private TextField overallScore;
    /**
     * Attribute that stores the button that updates selected player for the edit View
     */
    @FXML
    private Button updateButton;
    /**
     * Attribute that stores an Array of the text fields for the edit View
     */
    private TextField[] textFields;
    /**
     * Attribute that stores an Array of the score fields for the edit View
     */
    private TextField[] scoreFields;
    /**
     * Method that runs when the program initializes the edit View
     * (param details copied from super implementation)
     * @param url The location used to resolve relative paths for the root object
     * @param rb The resources used to localize the root object
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            textFields = new TextField[]{playerNumber, playerName, overallScore};
            scoreFields = new TextField[]{scores0, scores1, scores2, scores3, scores4, scores5};
            loadCompetitors();
            loadEdit();
        });
    }
    /**
     * Loads the edit View elements with their appropriate data
     */
    public void loadEdit() {
        competitorsList.setItems(FXCollections.observableList(competitorIds));
        playerLevel.setItems(FXCollections.observableList(Arrays.asList(Rank.values())));
        favoriteAttacker.setItems(FXCollections.observableList(Arrays.asList(R6Attacker.values())));
        favoriteDefender.setItems(FXCollections.observableList(Arrays.asList(R6Defender.values())));
        favoriteAgent.setItems(FXCollections.observableList(Arrays.asList(ValorantAgent.values())));
    }
    /**
     * Gets the player selected in the competitors list and loads the player in the editing area of the edit View
     */
    @FXML //Triggered when new list item is selected
    private void getCompetitor() {
        Competitor player = competitors.getCompetitors().get(competitorIds.indexOf(competitorsList.getSelectionModel().getSelectedItem()));
        loadPlayer(player);
    }
    /**
     * Updates the player that is loaded in the editing area of the edit View
     */
    @FXML //Triggered when the update button is pressed
    private void updateCompetitor() {
        int playerIndex = competitorIds.indexOf(competitorsList.getSelectionModel().getSelectedItem());
        Competitor player = competitors.getCompetitors().get(playerIndex);
        updatePlayer(player);
        competitorIds.set(playerIndex, player.getPlayerNumber());
        loadEdit();
        loadPlayer(player);
    }
    /**
     * Loads the selected player into the editing area of the edit View
     * @param player The player to load into the editing area
     */
    private void loadPlayer(Competitor player) {
        textFields[0].setText(String.valueOf(player.getPlayerNumber()));
        textFields[1].setText(player.getPlayerName().getFullName());
        playerLevel.getSelectionModel().select(player.getPlayerLevel());;
        textFields[2].setText(String.valueOf(player.getOverallScore()));
        loadFavoriteCharacters(player);
        loadScores(player);
    }
    /**
     * Loads the selected player's favorite character(s) into the editing area of the edit View
     * @param player The player that needs their character(s) loading
     */
    private void loadFavoriteCharacters(Competitor player) {
        if (player instanceof R6Player) {
            favoriteAttacker.getSelectionModel().select(((R6Player) player).getFavoriteAttacker());
            favoriteDefender.getSelectionModel().select((((R6Player) player).getFavoriteDefender()));
            favoriteAgent.visibleProperty().set(false);
            favoriteAttacker.visibleProperty().set(true);
            favoriteDefender.visibleProperty().set(true);
            favoriteCharacters.setText("Favorite Operators");
        }
        else if (player instanceof ValorantPlayer) {
            favoriteAgent.getSelectionModel().select(((ValorantPlayer) player).getFavoriteAgent());
            favoriteAgent.visibleProperty().set(true);
            favoriteAttacker.visibleProperty().set(false);
            favoriteDefender.visibleProperty().set(false);
            favoriteCharacters.setText("Favorite Agent");
        }
    }
    /**
     * Loads the selected player's scores into the editing area of the edit View
     * @param player The player that needs their scores loading
     */
    private void loadScores(Competitor player) {
        int[] playerScores = player.getScores();
        for (int i = 0; i < playerScores.length; i++) {
            scoreFields[i].setText(String.valueOf(playerScores[i]));
        }
    }
    /**
     * Updates the selected player's attributes
     * @param player The player that needs to be updated
     */
    private void updatePlayer(Competitor player) {
        player.setPlayerNumber(Integer.parseInt(textFields[0].getText()));
        player.setPlayerName(new Name(textFields[1].getText()));
        player.setPlayerLevel(playerLevel.getValue());
        updateFavoriteCharacters(player);
        updateScores(player);
    }
    /**
     * Updates the selected player's favorite character(s)
     * @param player The player that needs their character(s) updated
     */
    private void updateFavoriteCharacters(Competitor player) {
        if (player instanceof R6Player) {
            ((R6Player) player).setFavoriteAttacker(favoriteAttacker.getValue());
            ((R6Player) player).setFavoriteDefender(favoriteDefender.getValue());
        }
        else if (player instanceof ValorantPlayer) {
            ((ValorantPlayer) player).setFavoriteAgent(favoriteAgent.getValue());
        }
    }
    /**
     * Updates the selected player's scores
     * @param player The player that needs their scores updated
     */
    private void updateScores(Competitor player) {
        int[] newScores = new int[6];
        for (int i = 0; i < newScores.length; i++) {
            newScores[i] = Integer.parseInt(scoreFields[i].getText());
        }
        player.setScores(newScores);
    }
}