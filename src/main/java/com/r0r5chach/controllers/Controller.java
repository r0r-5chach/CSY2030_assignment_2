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
import javafx.scene.layout.AnchorPane;

public class Controller implements Initializable {
    @FXML
    protected AnchorPane editTab;

    @FXML
    protected AnchorPane viewTab;

    protected CompetitorList competitors;
    protected ArrayList<Integer> competitorIds;

    public void setCompetitors(CompetitorList competitors) {
        this.competitors = competitors;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            loadCompetitors();
            
        });        
    }

    @FXML
    protected void getEditTab() throws IOException {
        Parent root = Manager.loadFXML("pages/edit");
        editTab.getChildren().clear();
        editTab.getChildren().add(root);
    }

    @FXML
    protected void getViewTab() throws IOException {
        Parent root = Manager.loadFXML("pages/view");
        viewTab.getChildren().clear();
        viewTab.getChildren().add(root);
    }

    protected void loadCompetitors(){
        competitorIds = new ArrayList<Integer>();
        for (Competitor player : competitors.getCompetitors()) {
            competitorIds.add(player.getPlayerNumber()); 
        }
    }
}
