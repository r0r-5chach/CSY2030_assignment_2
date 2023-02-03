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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;

public class FiltersController implements Initializable {
    @FXML
    private TextField numberFilter;

    @FXML
    private TextField nameFilter;

    @FXML
    private ChoiceBox<Rank> levelFilter;

    @FXML
    private ToggleGroup typeFilter;

    @FXML
    private ChoiceBox<ValorantAgent> agentFilter;

    @FXML
    private ChoiceBox<R6Attacker> attackerFilter;

    @FXML
    private ChoiceBox<R6Defender> defenderFilter;

    @FXML
    private TextArea filterBox;

    private static String[] filters;

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

    @FXML
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

    public static String[] getFilters() {
        return filters;
    }

    private boolean isNull(String string) {
        if (string == null) {
            return true;
        }
        else {
            return false;
        }
    }
}
