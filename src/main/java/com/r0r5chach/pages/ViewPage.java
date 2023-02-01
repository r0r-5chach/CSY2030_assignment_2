package com.r0r5chach.pages;

import java.util.ArrayList;

import com.r0r5chach.competitor.Competitor;
import com.r0r5chach.competitor.Rank;
import com.r0r5chach.competitor.r6.R6Player;
import com.r0r5chach.competitor.valorant.ValorantPlayer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewPage {

    public static void generateTable(TableView<CompetitorRow> table) {
        TableColumn<CompetitorRow,Integer> playerNumCol = new TableColumn<CompetitorRow,Integer>("Player Number");
        TableColumn<CompetitorRow,String> playerNameCol = new TableColumn<CompetitorRow,String>("Player Name");
        TableColumn<CompetitorRow,Rank> playerLevelCol = new TableColumn<CompetitorRow,Rank>("Player Level");
        TableColumn<CompetitorRow,String> scoresCol = new TableColumn<CompetitorRow,String>("Player Scores");
        TableColumn<CompetitorRow,String> favoriteCharsCol = new TableColumn<CompetitorRow,String>("Favorite Characters");
        TableColumn<CompetitorRow,String> favoriteAgentCol = new TableColumn<CompetitorRow,String>("Agent");
        TableColumn<CompetitorRow,String> favoriteAttackerCol = new TableColumn<CompetitorRow,String>("Attacker");
        TableColumn<CompetitorRow,String> favoriteDefenderCol = new TableColumn<CompetitorRow,String>("Defender");
        playerNumCol.setCellValueFactory(new PropertyValueFactory<CompetitorRow,Integer>("playerNumber"));
        playerNameCol.setCellValueFactory(new PropertyValueFactory<CompetitorRow,String>("playerName"));
        playerLevelCol.setCellValueFactory(new PropertyValueFactory<CompetitorRow,Rank>("playerLevel"));
        scoresCol.setCellValueFactory(new PropertyValueFactory<CompetitorRow,String>("scores"));
        favoriteAgentCol.setCellValueFactory(new PropertyValueFactory<CompetitorRow,String>("favoriteAgent"));
        favoriteAttackerCol.setCellValueFactory(new PropertyValueFactory<CompetitorRow,String>("favoriteAttacker"));
        favoriteDefenderCol.setCellValueFactory(new PropertyValueFactory<CompetitorRow,String>("favoriteDefender"));
        table.getColumns().add(playerNumCol);
        table.getColumns().add(playerNameCol);
        table.getColumns().add(playerLevelCol);
        table.getColumns().add(scoresCol);
        favoriteCharsCol.getColumns().add(favoriteAgentCol);
        favoriteCharsCol.getColumns().add(favoriteAttackerCol);
        favoriteCharsCol.getColumns().add(favoriteDefenderCol);
        table.getColumns().add(favoriteCharsCol);
    }

    public static  ObservableList<CompetitorRow> loadTable(ArrayList<Competitor> list) {
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
    
}