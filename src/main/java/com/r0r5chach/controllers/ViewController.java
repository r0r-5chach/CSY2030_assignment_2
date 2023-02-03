package com.r0r5chach.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.r0r5chach.CompetitorRow;
import com.r0r5chach.Manager;
import com.r0r5chach.competitor.Competitor;
import com.r0r5chach.competitor.Rank;
import com.r0r5chach.competitor.r6.R6Player;
import com.r0r5chach.competitor.valorant.ValorantPlayer;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Popup;

public class ViewController extends Controller {
    @FXML
    private TableView<CompetitorRow> competitorTable;

    @FXML Button filterButton;

    private TableColumn<CompetitorRow,Integer> playerNumCol;
    private TableColumn<CompetitorRow,String> playerNameCol;
    private TableColumn<CompetitorRow,Rank> playerLevelCol;
    private TableColumn<CompetitorRow,String> scoresCol;
    private TableColumn<CompetitorRow,String> favoriteCharsCol;
    private TableColumn<CompetitorRow,String> favoriteAgentCol;
    private TableColumn<CompetitorRow,String> favoriteAttackerCol;
    private TableColumn<CompetitorRow,String> favoriteDefenderCol;

    private Popup filters;

    @Override
    public void initialize(URL ul, ResourceBundle rb) {
        Platform.runLater(() -> {
            loadCompetitors();
            loadView();
        });
    }

    public void generateTable() {
        initColumns();
        setColumnCellValues();
        addColumns();
    }

    public  ObservableList<CompetitorRow> loadTable(ArrayList<Competitor> list) {
        ArrayList<CompetitorRow> outputList = new ArrayList<>();
        for(Competitor player: list) {
            if (player instanceof ValorantPlayer) {
                outputList.add(new CompetitorRow(player.getPlayerNumber(), player.getPlayerName(), player.getPlayerLevel(), player.getScores(), ((ValorantPlayer) player).getFavoriteAgent()));
            }
            if (player instanceof R6Player) {
                outputList.add(new CompetitorRow(player.getPlayerNumber(), player.getPlayerName(), player.getPlayerLevel(), player.getScores(), ((R6Player) player).getFavoriteAttacker(), ((R6Player) player).getFavoriteDefender()));
            }
        }
        return FXCollections.observableArrayList(outputList);
    }

    private void loadView() {
        generateTable();
        competitorTable.setItems(loadTable(competitors.getCompetitors()));
    }

    private void initColumns() {
        playerNumCol = new TableColumn<CompetitorRow,Integer>("Player Number");
        playerNameCol = new TableColumn<CompetitorRow,String>("Player Name");
        playerLevelCol = new TableColumn<CompetitorRow,Rank>("Player Level");
        scoresCol = new TableColumn<CompetitorRow,String>("Player Scores");
        favoriteCharsCol = new TableColumn<CompetitorRow,String>("Favorite Characters");
        favoriteAgentCol = new TableColumn<CompetitorRow,String>("Agent");
        favoriteAttackerCol = new TableColumn<CompetitorRow,String>("Attacker");
        favoriteDefenderCol = new TableColumn<CompetitorRow,String>("Defender");
    }

    private void setColumnCellValues() {
        playerNumCol.setCellValueFactory(new PropertyValueFactory<CompetitorRow,Integer>("playerNumber"));
        playerNameCol.setCellValueFactory(new PropertyValueFactory<CompetitorRow,String>("playerName"));
        playerLevelCol.setCellValueFactory(new PropertyValueFactory<CompetitorRow,Rank>("playerLevel"));
        scoresCol.setCellValueFactory(new PropertyValueFactory<CompetitorRow,String>("scores"));
        favoriteAgentCol.setCellValueFactory(new PropertyValueFactory<CompetitorRow,String>("favoriteAgent"));
        favoriteAttackerCol.setCellValueFactory(new PropertyValueFactory<CompetitorRow,String>("favoriteAttacker"));
        favoriteDefenderCol.setCellValueFactory(new PropertyValueFactory<CompetitorRow,String>("favoriteDefender"));
    }

    private void addColumns() {
        competitorTable.getColumns().add(playerNumCol);
        competitorTable.getColumns().add(playerNameCol);
        competitorTable.getColumns().add(playerLevelCol);
        competitorTable.getColumns().add(scoresCol);
        favoriteCharsCol.getColumns().add(favoriteAgentCol);
        favoriteCharsCol.getColumns().add(favoriteAttackerCol);
        favoriteCharsCol.getColumns().add(favoriteDefenderCol);
        competitorTable.getColumns().add(favoriteCharsCol);
    }

    @FXML
    private void filterPress() throws IOException {
        switch(filterButton.getText().toLowerCase()) {
            case "filters" -> filterDialog();
            case "save" -> saveFilters();
        }
        
    } 

    private void filterDialog() throws IOException {
        filters = new Popup();
        Parent root = Manager.loadFXML("pages/filters");
        filters.getContent().add(root);
        filters.show(Manager.stage);
        filterButton.setText("Save");
    }

    private void saveFilters() {
        filters.hide();
        filterButton.setText("Filters");
        //TODO: filter implementation
    }
}