package com.r0r5chach;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import com.r0r5chach.r6.R6Attacker;
import com.r0r5chach.r6.R6Defender;
import com.r0r5chach.valorant.ValorantAgent;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class MainController implements Initializable {
    private CompetitorList competitors;
    private ArrayList<Integer> competitorIds;

    @FXML
    ListView<Integer> competitorsList;
    
    @FXML
    TextField playerNumber;

    @FXML
    TextField playerName;

    @FXML
    ChoiceBox<Rank> playerLevel;

    @FXML
    Text favoriteCharacters;

    @FXML
    ChoiceBox<R6Attacker> favoriteAttacker;

    @FXML
    ChoiceBox<ValorantAgent> favoriteAgent;

    @FXML
    ChoiceBox<R6Defender> favoriteDefender;

    @FXML
    TextField scores0;
    
    @FXML
    TextField scores1;
    
    @FXML
    TextField scores2;
    
    @FXML
    TextField scores3;
    
    @FXML
    TextField scores4;
    
    @FXML
    TextField scores5;

    @FXML
    TextField overallScore;
    
    TextField[] scores;

    TextField[] fields;

    @FXML
    Button updateButton;

    @FXML
    TableView<CompetitorRow> competitorTable;

    @FXML
    Button filterButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(() -> {
            scores = new TextField[]{scores0, scores1, scores2, scores3, scores4, scores5};
            fields = new TextField[]{playerNumber, playerName, overallScore};
            loadCompetitors();
            ViewPage.generateTable(competitorTable);
            loadEdit();
        });

    }

    public void setCompetitors(CompetitorList list) {
        this.competitors = list;
    }
    
    @FXML
    private void getCompetitor() {
        Competitor player = competitors.getCompetitors().get(competitorIds.indexOf(competitorsList.getSelectionModel().getSelectedItem()));
        EditPage.loadPlayer(player,fields, playerLevel);
        EditPage.loadFavoriteCharacters(player, favoriteAttacker, favoriteDefender, favoriteAgent, favoriteCharacters);
        EditPage.loadScores(player, scores);
    }

    @FXML
    private void updateCompetitor() {
        int playerIndex = competitorIds.indexOf(competitorsList.getSelectionModel().getSelectedItem());
        Competitor player = competitors.getCompetitors().get(playerIndex);
        EditPage.updatePlayer(player, fields, playerLevel);
        EditPage.updateFavoriteCharacters(player, favoriteAttacker, favoriteDefender, favoriteAgent);
        EditPage.updateScores(player, scores);
        competitorIds.set(playerIndex, player.getPlayerNumber());
        loadEdit();
        EditPage.loadPlayer(player, fields, playerLevel);
        EditPage.loadFavoriteCharacters(player, favoriteAttacker, favoriteDefender, favoriteAgent, favoriteCharacters);
        EditPage.loadScores(player, scores);
    }

    private void loadCompetitors(){
        this.competitorIds = new ArrayList<Integer>();
        for (Competitor player : this.competitors.getCompetitors()) {
            this.competitorIds.add(player.getPlayerNumber()); 
        }
    }

    @FXML
    private void loadEdit() {
        competitorsList.setItems(FXCollections.observableList(this.competitorIds));
        playerLevel.setItems(FXCollections.observableList(Arrays.asList(Rank.values())));
        favoriteAttacker.setItems(FXCollections.observableList(Arrays.asList(R6Attacker.values())));
        favoriteDefender.setItems(FXCollections.observableList(Arrays.asList(R6Defender.values())));
        favoriteAgent.setItems(FXCollections.observableList(Arrays.asList(ValorantAgent.values())));
    }

    @FXML
    private void loadView() {
        competitorTable.setItems(ViewPage.loadTable(this.competitors.getCompetitors()));
    }
}