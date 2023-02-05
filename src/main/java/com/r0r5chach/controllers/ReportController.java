package com.r0r5chach.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
/**
 * Class that defines the controller for the report View of the GUI
 * Inherits from com.r0r5chach.controllers.Controller
 * @author r0r5chach
 */
public class ReportController extends Controller {
    /**
     * Attribute that stores the competitor list for the report View
     */
    @FXML
    private ListView<Integer> competitorList;
    /**
     * Attribute that stores the output area for the report View
     */
    @FXML
    private TextArea outputArea;
    /**
     * Method that runs when the program initializes the edit View
     * (param details copied from super implementation)
     * @param url The location used to resolve relative paths for the root object
     * @param rb The resources used to localize the root object
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(() -> {
            loadCompetitors();
            competitorList.setItems(FXCollections.observableList(competitorIds)); 
        });
    }
    /**
     * Outputs the short details of the selected player to the output area
     */
    @FXML //Triggers when the short details button is pressed
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
    /**
     * Outputs the full details of the selected player to the output area
     */
    @FXML //Triggers when the full details button is pressed
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