package com.r0r5chach;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import com.r0r5chach.competitor.Competitor;
import com.r0r5chach.competitor.Rank;
import com.r0r5chach.competitor.r6.R6Attacker;
import com.r0r5chach.competitor.r6.R6Defender;
import com.r0r5chach.competitor.valorant.ValorantAgent;
import com.r0r5chach.pages.CompetitorRow;

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

import static com.r0r5chach.pages.EditPage.loadPlayer;
import static com.r0r5chach.pages.EditPage.loadFavoriteCharacters;
import static com.r0r5chach.pages.EditPage.loadScores;
import static com.r0r5chach.pages.EditPage.updatePlayer;
import static com.r0r5chach.pages.EditPage.updateFavoriteCharacters;
import static com.r0r5chach.pages.EditPage.updateScores;
import static com.r0r5chach.pages.ViewPage.generateTable;
import static com.r0r5chach.pages.ViewPage.loadTable;

public class MainController implements Initializable {
    private CompetitorList competitors;
    private ArrayList<Integer> competitorIds;

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
    
    private TextField[] scores;

    private TextField[] fields;

    @FXML
    private Button updateButton;

    @FXML
    private TableView<CompetitorRow> competitorTable;

    @FXML
    private Button filterButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(() -> {
            scores = new TextField[]{scores0, scores1, scores2, scores3, scores4, scores5};
            fields = new TextField[]{playerNumber, playerName, overallScore};
            loadCompetitors();
            generateTable(competitorTable);
            loadEdit();
        });

    }

    public void setCompetitors(CompetitorList list) {
        this.competitors = list;
    }
    
    @FXML
    private void getCompetitor() {
        Competitor player = competitors.getCompetitors().get(competitorIds.indexOf(competitorsList.getSelectionModel().getSelectedItem()));
        loadPlayer(player,fields, playerLevel);
        loadFavoriteCharacters(player, favoriteAttacker, favoriteDefender, favoriteAgent, favoriteCharacters);
        loadScores(player, scores);
    }

    @FXML
    private void updateCompetitor() {
        int playerIndex = competitorIds.indexOf(competitorsList.getSelectionModel().getSelectedItem());
        Competitor player = competitors.getCompetitors().get(playerIndex);
        updatePlayer(player, fields, playerLevel);
        updateFavoriteCharacters(player, favoriteAttacker, favoriteDefender, favoriteAgent);
        updateScores(player, scores);
        competitorIds.set(playerIndex, player.getPlayerNumber());
        loadEdit();
        loadPlayer(player, fields, playerLevel);
        loadFavoriteCharacters(player, favoriteAttacker, favoriteDefender, favoriteAgent, favoriteCharacters);
        loadScores(player, scores);
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
        competitorTable.setItems(loadTable(this.competitors.getCompetitors()));
    }
}