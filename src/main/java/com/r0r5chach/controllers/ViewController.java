package com.r0r5chach.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import static com.r0r5chach.controllers.FiltersController.getFilters;

import com.r0r5chach.CompetitorList;
import com.r0r5chach.CompetitorRow;
import com.r0r5chach.Manager;
import com.r0r5chach.competitor.Competitor;
import com.r0r5chach.competitor.Rank;
import com.r0r5chach.competitor.r6.R6Player;
import com.r0r5chach.competitor.valorant.ValorantPlayer;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Popup;
/**
 * Class that defines the Controller for the view View (view.fxml) of the GUI
 * Inherits from com.r0r5chach.controllers.Controller
 * @author r0r5chach
 */
public class ViewController extends Controller {
    /**
     * Attribute that stores the table view for the view View
     */
    @FXML
    private TableView<CompetitorRow> competitorTable;
    /**
     * Attribute that stores the players' number column
     */
    private TableColumn<CompetitorRow,Integer> playerNumCol;
    /**
     * Attribute that stores the players' name column
     */
    private TableColumn<CompetitorRow,String> playerNameCol;
    /**
     * Attribute that stores the players' level column
     */
    private TableColumn<CompetitorRow,Rank> playerLevelCol;
    /**
     * Attribute that stores the players' scores column
     */
    private TableColumn<CompetitorRow,String> scoresCol;
    /**
     * Attribute that stores the players' favorite characters column
     */
    private TableColumn<CompetitorRow,String> favoriteCharsCol;
    /**
     * Attribute that stores the players' favorite agent column
     * This is a sub column of the players' favorite characters column
     */
    private TableColumn<CompetitorRow,String> favoriteAgentCol;
    /**
     * Attribute that stores the players' favorite attacker column
     * This is a sub column of the players' favorite characters column
     */
    private TableColumn<CompetitorRow,String> favoriteAttackerCol;
    /**
     * Attribute that stores the players' favorite defender column
     * This is a sub column of the players' favorite characters column
     */
    private TableColumn<CompetitorRow,String> favoriteDefenderCol;
    /**
     * Attribute that stores the filter button for the view View
     */
    @FXML 
    private Button filterButton;
    /**
     * Attribute that stores the filter popup
     */
    private Popup filterPopup;
    /**
     * Attribute that stores the Array that contains active filters
     */
    private String[] filters;
    /**
     * Method that runs when the program initializes the edit View
     * (param details copied from super implementation)
     * @param url The location used to resolve relative paths for the root object
     * @param rb The resources used to localize the root object
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(() -> {
            filters = new String[]{"", "", "", "", "", "", ""};
            filterPopup = new Popup();
            filter();
            loadCompetitors();
            loadView();
        });
    }
    /**
     * Either opens the filters popup or saves the filter selection dependant on what state the button is in
     */
    @FXML //Triggers when filter/save button is pressed
    private void filterPress() {
        switch(filterButton.getText().toLowerCase()) {
            case "filters" -> filterDialog();
            case "save" -> saveFilters();
        }
        
    } 
    /**
     * Generates the table
     */
    private void generateTable() {
        initColumns();
        setColumnCellValues();
        addColumns();
    }
    /**
     * Defines the predicate that controls filtering for the table
     * @return The predicate
     */
    private Predicate<CompetitorRow> filter() {
        Predicate<CompetitorRow> test = competitor -> {
            boolean flag = true;

            if (!Integer.toString(competitor.getPlayerNumber()).toLowerCase().contains(filters[0].toLowerCase())) {
                flag = false;
            }

            if (!competitor.getPlayerName().toLowerCase().contains(filters[1].toLowerCase())) {
                flag = false;
            }

            if (!competitor.getPlayerLevel().toString().toLowerCase().contains(filters[2].toLowerCase())) {
                flag = false;
            }

            if (filters[3].equals("R6") && competitor.getFavoriteAttacker().toString().equals("N/A")) {
                flag = false;
            }

            if (filters[3].equals("Valorant") && competitor.getFavoriteAgent().toString().equals("N/A")) {
                flag = false;
            }

            if (!competitor.getFavoriteAgent().toString().toLowerCase().contains(filters[4])) {
                flag = false;
            }

            if (!competitor.getFavoriteAttacker().toString().toLowerCase().contains(filters[5])) {
                flag = false;
            }

            if (!competitor.getFavoriteDefender().toString().toLowerCase().contains(filters[6])) {
                flag = false;
            }


            return flag;
            
        };
        return test;
    }
    /**
     * Loads the rows of data into usable data for the table
     * @param list The list of competitors to be loaded into the table
     * @return The list of rows as usable data
     */
    private  ObservableList<CompetitorRow> loadTable(ArrayList<Competitor> list) {
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
    /**
     * Loads the view View elements with their appropriate data
     */
    private void loadView() {
        ObservableList<CompetitorRow> table = loadTable(competitors.getCompetitors());
        generateTable();
        if (filterCheck()) {
            FilteredList<CompetitorRow> data = new FilteredList<>(table, filter());
            SortedList<CompetitorRow> sortedData = new SortedList<>(data);
            sortedData.comparatorProperty().bind(competitorTable.comparatorProperty());
            competitorTable.setItems(sortedData);
        }
        else {
            competitorTable.setItems(table);
        }
    }
    /**
     * Initializes the table columns
     */
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
    /**
     * Sets the appropriate attribute to the corresponding column
     */
    private void setColumnCellValues() {
        playerNumCol.setCellValueFactory(new PropertyValueFactory<CompetitorRow,Integer>("playerNumber"));
        playerNameCol.setCellValueFactory(new PropertyValueFactory<CompetitorRow,String>("playerName"));
        playerLevelCol.setCellValueFactory(new PropertyValueFactory<CompetitorRow,Rank>("playerLevel"));
        scoresCol.setCellValueFactory(new PropertyValueFactory<CompetitorRow,String>("scores"));
        favoriteAgentCol.setCellValueFactory(new PropertyValueFactory<CompetitorRow,String>("favoriteAgent"));
        favoriteAttackerCol.setCellValueFactory(new PropertyValueFactory<CompetitorRow,String>("favoriteAttacker"));
        favoriteDefenderCol.setCellValueFactory(new PropertyValueFactory<CompetitorRow,String>("favoriteDefender"));
    }
    /**
     * Add the table columns to the table
     */
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
    /**
     * Open the filters popup and change the state of the button
     */
    private void filterDialog() {
        filterPopup = new Popup();
        Parent root = null;
        try {
            root = Manager.loadFXML("pages/filters");
        }
        catch (IOException e) {
            CompetitorList.createErrorLog(e, "src/main/resources/com/r0r5chach");
        }
        filterPopup.getContent().add(root);
        filterPopup.show(Manager.stage);
        filterButton.setText("Save");
    }
    /**
     * Save the filter selection from the filters popup
     */
    private void saveFilters() {
        filterPopup.hide();
        filterButton.setText("Filters");
        filters = getFilters();
        loadView();
    }
    /**
     * Checks if a filter is selected
     * @return true if a filter is selected; false otherwise
     */
    private boolean filterCheck() {
        for(String filter: filters) {
            if (!filter.equals("")) {
                return true;
            }
        }  
        return false; 
    }
}