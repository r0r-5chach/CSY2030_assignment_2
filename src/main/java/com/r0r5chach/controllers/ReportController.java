package com.r0r5chach.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class ReportController extends Controller {
    @FXML
    private ListView<Integer> competitorList;

    @FXML
    private TextArea outputArea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(() -> {
            loadCompetitors();
            competitorList.setItems(FXCollections.observableList(competitorIds)); 
        });
    }
    
    @FXML
    private void shortDetailsPress() {
        Integer item = competitorList.getSelectionModel().getSelectedItem();
        outputArea.clear();
        if (item != null) {
            outputArea.setText(competitors.getCompetitors().get(competitorIds.indexOf(item)).getShortDetails());
        }
        else {
            outputArea.setText("Select A Competitor");
        }
    }

    @FXML
    private void fullDetailsPress() {
        Integer item = competitorList.getSelectionModel().getSelectedItem();
        if (item != null) {
            outputArea.clear();
            outputArea.setText(competitors.getCompetitors().get(competitorIds.indexOf(item)).getFullDetails());
        }
        else {
            outputArea.setText("Select A Competitor");
        }
    }
}
