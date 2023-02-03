package com.r0r5chach.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.r0r5chach.CompetitorList.createErrorLog;
import com.r0r5chach.CompetitorList;
import com.r0r5chach.Manager;
import com.r0r5chach.competitor.Competitor;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
/**
 * Class that defines a generic controller for the GUI
 * Inherits from javafx.fxml.Initializable
 */
public class Controller implements Initializable {
    /**
     * Attribute that stores the Main Pane for the GUI view
     */
    @FXML
    protected TabPane tabs;
    /**
     * Attribute that stores the competitor list used by the program
     */
    protected CompetitorList competitors;
    /**
     * Attribute that stores the playerNumber of each competitor in the same order as the competitors list to allow easy indexing of competitors list
     */
    protected ArrayList<Integer> competitorIds;
    /**
     * Method that runs when the program initializes the GUI view
     * (param details copied from super implementation)
     * @param url The location used to resolve relative paths for the root object
     * @param rb The resources used to localize the root object
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(() -> {
            loadCompetitors();
        });        
    }
    /**
     * Sets the controller's competitor list to that of the new parameter
     * @param competitors the new competitor list
     */
    public void setCompetitors(CompetitorList competitors) {
        this.competitors = competitors;
    }
    /**
     * Gets the controller's competitor list
     * @return the controller's competitor list
     */
    public CompetitorList getCompetitors() {
        return competitors;
    }
    /**
     * Gets the tab selected on the GUI
     */
    @FXML
    protected void getTab() {
        Parent root = null;
        Tab tab = tabs.getSelectionModel().getSelectedItem();
        try {
            switch(tab.getText().toLowerCase()) {
                case "view" -> root = Manager.loadFXML("pages/view");
                case "edit" -> root = Manager.loadFXML("pages/edit");
                case "report" -> root = Manager.loadFXML("pages/report");
            }
        }
        catch (IOException e) {
            createErrorLog(e, "src/main/resources/com/r0r5chach/log.txt");
        }
        tab.setContent(root);
    }
    /**
     * Initializes the competitorIds array for the controller
     */
    protected void loadCompetitors(){
        competitorIds = new ArrayList<Integer>();
        for (Competitor player : competitors.getCompetitors()) {
            competitorIds.add(player.getPlayerNumber()); 
        }
    }
}