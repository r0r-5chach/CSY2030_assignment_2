package com.r0r5chach.controllers;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import com.r0r5chach.competitor.Rank;
import com.r0r5chach.competitor.r6.R6Attacker;
import com.r0r5chach.competitor.r6.R6Defender;
import com.r0r5chach.competitor.valorant.ValorantAgent;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
/**
 * Class that defines the controller for the filters View (filters.fxml) of the GUI
 * Inherits from com.r0r5chach.controllers.Controller
 * @author r0r5chach
 */
public class FiltersController implements Initializable {
    /**
     * Attribute that stores the filter for player number for the filter View
     */
    @FXML
    private TextField numberFilter;
    /**
     * Attribute that stores the filter for player name for the filter View
     */
    @FXML
    private TextField nameFilter;
    /**
     * Attribute that stores the filter for player level for the filter View
     */
    @FXML
    private ChoiceBox<Rank> levelFilter;
    /**
     * Attribute that stores the filter for player type for the filter View
     */
    @FXML
    private ToggleGroup typeFilter;
    /**
     * Attribute that stores the filter for player's favorite agent for the filter View
     */
    @FXML
    private ChoiceBox<ValorantAgent> agentFilter;
    /**
     * Attribute that stores the filter for player's favorite attacker for the filter View
     */
    @FXML
    private ChoiceBox<R6Attacker> attackerFilter;
    /**
     * Attribute that stores the filter for player's favorite defender for the filter View
     */
    @FXML
    private ChoiceBox<R6Defender> defenderFilter;
    /**
     * Attribute that stores the Array of currently selected filters for the filter View
     */
    private static String[] filters;
    /**
     * Method that runs when the program initializes the edit View
     * (param details copied from super implementation)
     * @param url The location used to resolve relative paths for the root object
     * @param rb The resources used to localize the root object
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        attackerFilter.setItems(FXCollections.observableList(Arrays.asList(R6Attacker.values())));
        attackerFilter.setValue(R6Attacker.NONE);
        defenderFilter.setItems(FXCollections.observableList(Arrays.asList(R6Defender.values())));
        defenderFilter.setValue(R6Defender.NONE);
        agentFilter.setItems(FXCollections.observableList(Arrays.asList(ValorantAgent.values())));
        agentFilter.setValue(ValorantAgent.NONE);
        levelFilter.setItems(FXCollections.observableList(Arrays.asList(Rank.values())));
        levelFilter.setValue(Rank.NONE);
    }
    /**
     * Gets the Array of currently selected filters
     * @return the Array of currently selected filters
     */
    public static String[] getFilters() {
        return filters;
    }
    /**
     * Sets the currently selected filters based off of the selections on the filters View
     */
    @FXML //Triggers when mouse leaves the area of any of the selection boxes
    private void setFilters() {
        String[] output = new String[7];
        for(int i= 0;i < output.length;i++ ) {
            String filter = null;
            switch(i) {
                case 0 -> filter = numberFilter.getText();
                case 1 -> filter = nameFilter.getText();
                case 2 -> filter = levelFilter.getSelectionModel().getSelectedItem().toString();
                case 3 -> filter = ((RadioButton)typeFilter.getSelectedToggle()).getText();
                case 4 -> filter = agentFilter.getSelectionModel().getSelectedItem().toString();
                case 5 -> filter = attackerFilter.getSelectionModel().getSelectedItem().toString();
                case 6 -> filter = defenderFilter.getSelectionModel().getSelectedItem().toString();
                default -> filter = "";
            }

            if (isNull(filter) || filter.equals("NONE")) {
                output[i] = "";
            }
            else {
                output[i] = filter;
            }
        }

        filters = output;
    }
    /**
     * Checks to see if a string is null
     * @param string The string to be checked
     * @return true if null; false otherwise
     */
    private boolean isNull(String string) {
        if (string == null) {
            return true;
        }
        else {
            return false;
        }
    }
}