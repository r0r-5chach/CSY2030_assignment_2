package com.r0r5chach;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.r0r5chach.r6.R6Player;
import com.r0r5chach.valorant.ValorantPlayer;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
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
    TextField playerLevel;

    @FXML
    Text favoriteCharacters;

    @FXML
    TextField favoriteAttacker;

    @FXML
    TextField favoriteDefender;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadCompetitors();
        this.scores = new TextField[]{scores0, scores1, scores2, scores3, scores4, scores5};
        loadView();
    }    

    private void loadCompetitors(){
        this.competitors = new Manager().getCompetitors();
        this.competitorIds = new ArrayList<Integer>();
        for (Competitor player : this.competitors.getCompetitors()) {
            this.competitorIds.add(player.getPlayerNumber()); 
        }
    }

    private void loadView() {
        competitorsList.setItems(FXCollections.observableArrayList(this.competitorIds));
    }

    @FXML
    public void getCompetitor() {
        Competitor player = this.competitors.getCompetitors().get(this.competitorIds.indexOf(this.competitorsList.getSelectionModel().getSelectedItem()));
        loadPlayer(player);
    }

    private void loadPlayer(Competitor player) {
        this.playerNumber.setText(String.valueOf(player.getPlayerNumber()));
        this.playerName.setText(player.getPlayerName().getFullName());
        this.playerLevel.setText(player.getPlayerLevel().getRank());
        loadFavoriteCharacters(player);
        loadScores(player);
        this.overallScore.setText(String.valueOf(player.getOverallScore()));
    }

    private void loadFavoriteCharacters(Competitor player) {
        if (player instanceof R6Player) {
            this.favoriteAttacker.setText(((R6Player) player).getFavoriteAttacker().getAttacker());
            this.favoriteDefender.setText(((R6Player) player).getFavoriteDefender().getDefender());
            this.favoriteDefender.visibleProperty().set(true);
            this.favoriteCharacters.setText("Favorite Operators");
        }
        else if (player instanceof ValorantPlayer) {
            this.favoriteAttacker.setText(((ValorantPlayer) player).getFavoriteAgent().getAgent());
            this.favoriteDefender.visibleProperty().set(false);
            this.favoriteCharacters.setText("Favorite Agent");
        }
    }

    private void loadScores(Competitor player) {
        int[] playerScores = player.getScores();
        for (int i = 0; i < playerScores.length; i++) {
            this.scores[i].setText(String.valueOf(playerScores[i]));
        }
    }
}