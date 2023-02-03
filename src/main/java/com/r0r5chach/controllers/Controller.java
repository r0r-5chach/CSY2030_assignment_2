package com.r0r5chach.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.r0r5chach.CompetitorList;
import com.r0r5chach.Manager;
import com.r0r5chach.competitor.Competitor;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

public class Controller implements Initializable {
    @FXML
    protected AnchorPane editTab;

    @FXML
    protected AnchorPane viewTab;

    @FXML
    protected AnchorPane reportTab;

    @FXML
    protected TabPane tabs;

    protected CompetitorList competitors;
    protected ArrayList<Integer> competitorIds;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            loadCompetitors();
        });        
    }
    
    public void setCompetitors(CompetitorList competitors) {
        this.competitors = competitors;
    }
    
    public CompetitorList getCompetitors() {
        return competitors;
    }

    @FXML
    protected void getTab() throws IOException {
        Parent root = null;
        Tab tab = tabs.getSelectionModel().getSelectedItem();
        switch(tab.getText().toLowerCase()) {
            case "view" -> root = Manager.loadFXML("pages/view");
            case "edit" -> root = Manager.loadFXML("pages/edit");
            case "report" -> root = Manager.loadFXML("pages/report");
        }
        tab.setContent(root);
    }

    protected void loadCompetitors(){
        competitorIds = new ArrayList<Integer>();
        for (Competitor player : competitors.getCompetitors()) {
            competitorIds.add(player.getPlayerNumber()); 
        }
    }
}
