package com.r0r5chach.controllers;

import com.r0r5chach.Manager;
import com.r0r5chach.competitor.Rank;
import com.r0r5chach.competitor.valorant.ValorantAgent;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class FiltersController {
    @FXML
    private TextField numberFilter;

    @FXML
    private TextField nameFilter;

    @FXML
    ChoiceBox<Rank> levelFilter;

    @FXML
    private TextField scoreFilter;

    @FXML
    private ToggleGroup typeFilter;

    @FXML
    ChoiceBox<ValorantAgent> agentFilter;

    @FXML
    private void filterSave() {
        Manager.filtersClose();
    }
}
