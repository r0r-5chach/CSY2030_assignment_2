package com.r0r5chach;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import com.r0r5chach.r6.R6Attacker;
import com.r0r5chach.r6.R6Defender;
import com.r0r5chach.r6.R6Player;
import com.r0r5chach.valorant.ValorantAgent;
import com.r0r5chach.valorant.ValorantPlayer;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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

    @FXML
    Button updateButton;

    @FXML
    TableView<CompetitorRow> competitorTable;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(() -> {
            this.scores = new TextField[]{scores0, scores1, scores2, scores3, scores4, scores5};
            loadCompetitors();
            loadTable();
            loadEdit();
        });

    }

    public void setCompetitors(CompetitorList list) {
        this.competitors = list;
    }
    
    @FXML
    private void getCompetitor() {
        Competitor player = this.competitors.getCompetitors().get(this.competitorIds.indexOf(this.competitorsList.getSelectionModel().getSelectedItem()));
        loadPlayer(player);
    }

    @FXML
    private void updateCompetitor() {
        int playerIndex = this.competitorIds.indexOf(this.competitorsList.getSelectionModel().getSelectedItem());
        Competitor player = this.competitors.getCompetitors().get(playerIndex);
        updatePlayer(player);
        competitorIds.set(playerIndex, player.getPlayerNumber());
        loadEdit();
        loadPlayer(player);
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

    private void loadTable() {
        TableColumn<CompetitorRow,Integer> playerNumCol = new TableColumn<CompetitorRow,Integer>("Player Number");
        TableColumn<CompetitorRow,String> playerNameCol = new TableColumn<CompetitorRow,String>("Player Name");
        TableColumn<CompetitorRow,Rank> playerLevelCol = new TableColumn<CompetitorRow,Rank>("Player Level");
        TableColumn<CompetitorRow,int[]> scoresCol = new TableColumn<CompetitorRow,int[]>("Player Scores");
        playerNumCol.setCellValueFactory(new PropertyValueFactory<CompetitorRow,Integer>("playerNumber"));
        playerNameCol.setCellValueFactory(new PropertyValueFactory<CompetitorRow,String>("playerName"));
        playerLevelCol.setCellValueFactory(new PropertyValueFactory<CompetitorRow,Rank>("playerLevel"));
        scoresCol.setCellValueFactory(new PropertyValueFactory<CompetitorRow,int[]>("scores"));
        competitorTable.getColumns().add(playerNumCol);
        competitorTable.getColumns().add(playerNameCol);
        competitorTable.getColumns().add(playerLevelCol);
        competitorTable.getColumns().add(scoresCol);
    }

    @FXML
    private void loadView() {
        competitorTable.setItems(generateTable());
        //TODO: Add favorite characters
    }

    private void loadPlayer(Competitor player) {
        this.playerNumber.setText(String.valueOf(player.getPlayerNumber()));
        this.playerName.setText(player.getPlayerName().getFullName());
        this.playerLevel.getSelectionModel().select(player.getPlayerLevel());;
        loadFavoriteCharacters(player);
        loadScores(player);
        this.overallScore.setText(String.valueOf(player.getOverallScore()));
    }

    private void loadFavoriteCharacters(Competitor player) {
        if (player instanceof R6Player) {
            this.favoriteAttacker.getSelectionModel().select(((R6Player) player).getFavoriteAttacker());
            this.favoriteDefender.getSelectionModel().select((((R6Player) player).getFavoriteDefender()));
            this.favoriteAgent.visibleProperty().set(false);
            this.favoriteAttacker.visibleProperty().set(true);
            this.favoriteDefender.visibleProperty().set(true);
            this.favoriteCharacters.setText("Favorite Operators");
        }
        else if (player instanceof ValorantPlayer) {
            this.favoriteAgent.getSelectionModel().select(((ValorantPlayer) player).getFavoriteAgent());
            this.favoriteAgent.visibleProperty().set(true);
            this.favoriteAttacker.visibleProperty().set(false);
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

    private void updatePlayer(Competitor player) {
        player.setPlayerNumber(Integer.parseInt(this.playerNumber.getText()));
        player.setPlayerName(new Name(this.playerName.getText()));
        player.setPlayerLevel(this.playerLevel.getValue());
        updateFavoriteCharacters(player);
        updateScores(player);
    }

    private void updateFavoriteCharacters(Competitor player) {
        if (player instanceof R6Player) {
            ((R6Player) player).setFavoriteAttacker(this.favoriteAttacker.getValue());
            ((R6Player) player).setFavoriteDefender(this.favoriteDefender.getValue());
        }
        else if (player instanceof ValorantPlayer) {
            ((ValorantPlayer) player).setFavoriteAgent(this.favoriteAgent.getValue());
        }
    }

    private void updateScores(Competitor player) {
        int[] newScores = new int[6];
        for (int i = 0; i < newScores.length; i++) {
            newScores[i] = Integer.parseInt(this.scores[i].getText());
        }
        player.setScores(newScores);
    }

    private  ObservableList<CompetitorRow> generateTable() {
        ArrayList<CompetitorRow> list = new ArrayList<>();
        for(Competitor player: this.competitors.getCompetitors()) {
            if (player instanceof ValorantPlayer) {
                list.add(new CompetitorRow(player.getPlayerNumber(), player.getPlayerName(), player.getPlayerLevel(), player.getScores(), ((ValorantPlayer) player).getFavoriteAgent()));
            }
            else if (player instanceof R6Player) {
                list.add(new CompetitorRow(player.getPlayerNumber(), player.getPlayerName(), player.getPlayerLevel(), player.getScores(), ((R6Player) player).getFavoriteAttacker(), ((R6Player) player).getFavoriteDefender()));
            }
            else {
                list.add(new CompetitorRow(player.getPlayerNumber(), player.getPlayerName(), player.getPlayerLevel(), player.getScores()));
            }
        }
        return FXCollections.observableArrayList(list);
    }
}