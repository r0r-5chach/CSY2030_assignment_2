package com.r0r5chach;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class MainController {
    private CompetitorList competitors;

    @FXML
    private ListView<Competitor> competitorsList;
    public MainController() {
        loadCompetitors();
    }

    private void loadCompetitors(){
        this.competitors = new Manager().getCompetitors();
        this.competitorsList = new ListView<Competitor>(FXCollections.observableList(this.competitors.getCompetitors()));
    }
}
