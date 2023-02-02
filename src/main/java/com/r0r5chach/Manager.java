package com.r0r5chach;
import java.io.File;

import javafx.application.Application;
import java.io.IOException;

import com.r0r5chach.controllers.MainController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.scene.Scene;
import static com.r0r5chach.CompetitorList.createErrorLog;

public class Manager extends Application {

    private static Scene scene;
    private static Stage stage;
    private static Popup filters;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("main"), 640, 480);
        Manager.stage = stage;
        Manager.stage.setScene(scene);
        Manager.stage.show();
    }

    @Override
    public void stop() {
        //TODO: output report to file
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Manager.class.getResource(fxml + ".fxml"));
        Parent root = fxmlLoader.load();
        MainController controller = fxmlLoader.<MainController>getController();
        controller.setCompetitors(createList());
        
        return root;
    }

    public static void main(String[] args) {
        launch();
    }

    private static CompetitorList createList() {
        CompetitorList competitors = null;
        File valorantPlayers = new File("src/main/resources/com/r0r5chach/valorantPlayers.txt");
        File r6Players = new File("src/main/resources/com/r0r5chach/r6Players.txt");
        try {
            competitors = new CompetitorList();
            competitors.readCompetitors(valorantPlayers);
            competitors.readCompetitors(r6Players);
        }
        catch (Exception e) {
            createErrorLog(e, "src/main/resources/log.txt");
        }
        return competitors;
    }

    public static void filtersOpen() throws IOException {
        filters = new Popup();
        FXMLLoader loader = new FXMLLoader(Manager.class.getResource("pages/filters.fxml"));
        filters.getContent().add((Parent)loader.load());
        filters.show(Manager.stage);
    }

    public static void filtersClose() {
        filters.hide();
    }

}
