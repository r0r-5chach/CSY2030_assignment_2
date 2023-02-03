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


public class EditController extends Controller {

    @FXML
    private ListView<Integer> competitorsList;
    
    @FXML
    private TextField playerNumber;

    @FXML
    private TextField playerName;

    @FXML
    private ChoiceBox<Rank> playerLevel;

    @FXML
    private Text favoriteCharacters;

    @FXML
    private ChoiceBox<R6Attacker> favoriteAttacker;

    @FXML
    private ChoiceBox<ValorantAgent> favoriteAgent;

    @FXML
    private ChoiceBox<R6Defender> favoriteDefender;

    @FXML
    private TextField scores0;
    
    @FXML
    private TextField scores1;
    
    @FXML
    private TextField scores2;
    
    @FXML
    private TextField scores3;
    
    @FXML
    private TextField scores4;
    
    @FXML
    private TextField scores5;

    @FXML
    private TextField overallScore;

    @FXML
    private Button updateButton;

    private TextField[] textFields;

    private TextField[] scoreFields;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            textFields = new TextField[]{playerNumber, playerName, overallScore};
            scoreFields = new TextField[]{scores0, scores1, scores2, scores3, scores4, scores5};
            loadCompetitors();
            loadEdit();
        });
    }

    
    private void loadPlayer(Competitor player) {
        textFields[0].setText(String.valueOf(player.getPlayerNumber()));
        textFields[1].setText(player.getPlayerName().getFullName());
        playerLevel.getSelectionModel().select(player.getPlayerLevel());;
        textFields[2].setText(String.valueOf(player.getOverallScore()));
        loadFavoriteCharacters(player);
        loadScores(player);
    }

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

    private void loadScores(Competitor player) {
        int[] playerScores = player.getScores();
        for (int i = 0; i < playerScores.length; i++) {
            scoreFields[i].setText(String.valueOf(playerScores[i]));
        }
    }

    private void updatePlayer(Competitor player) {
        player.setPlayerNumber(Integer.parseInt(textFields[0].getText()));
        player.setPlayerName(new Name(textFields[1].getText()));
        player.setPlayerLevel(playerLevel.getValue());
        updateFavoriteCharacters(player);
        updateScores(player);
    }

    private void updateFavoriteCharacters(Competitor player) {
        if (player instanceof R6Player) {
            ((R6Player) player).setFavoriteAttacker(favoriteAttacker.getValue());
            ((R6Player) player).setFavoriteDefender(favoriteDefender.getValue());
        }
        else if (player instanceof ValorantPlayer) {
            ((ValorantPlayer) player).setFavoriteAgent(favoriteAgent.getValue());
        }
    }

    private void updateScores(Competitor player) {
        int[] newScores = new int[6];
        for (int i = 0; i < newScores.length; i++) {
            newScores[i] = Integer.parseInt(scoreFields[i].getText());
        }
        player.setScores(newScores);
    }

    @FXML
    private void getCompetitor() {
        Competitor player = competitors.getCompetitors().get(competitorIds.indexOf(competitorsList.getSelectionModel().getSelectedItem()));
        loadPlayer(player);
    }

    @FXML
    private void updateCompetitor() {
        int playerIndex = competitorIds.indexOf(competitorsList.getSelectionModel().getSelectedItem());
        Competitor player = competitors.getCompetitors().get(playerIndex);
        updatePlayer(player);
        competitorIds.set(playerIndex, player.getPlayerNumber());
        loadEdit();
        loadPlayer(player);
    }

    public void loadEdit() {
        competitorsList.setItems(FXCollections.observableList(competitorIds));
        playerLevel.setItems(FXCollections.observableList(Arrays.asList(Rank.values())));
        favoriteAttacker.setItems(FXCollections.observableList(Arrays.asList(R6Attacker.values())));
        favoriteDefender.setItems(FXCollections.observableList(Arrays.asList(R6Defender.values())));
        favoriteAgent.setItems(FXCollections.observableList(Arrays.asList(ValorantAgent.values())));
    }
}