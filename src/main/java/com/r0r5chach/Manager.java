package com.r0r5chach;
import java.io.File;

import javafx.application.Application;
import java.io.IOException;

import com.r0r5chach.controllers.Controller;
import com.r0r5chach.controllers.EditController;
import com.r0r5chach.controllers.MainController;
import com.r0r5chach.controllers.ViewController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import static com.r0r5chach.CompetitorList.createErrorLog;

public class Manager extends Application {

    private static Scene scene;
    public static Stage stage;
    private static CompetitorList competitors;

    @Override
    public void start(Stage stage) throws IOException {
        competitors = createList();
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

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Manager.class.getResource(fxml + ".fxml"));
        Parent root = fxmlLoader.load();
        Controller controller;
        switch(fxml) {
            case "main":
                controller = fxmlLoader.<MainController>getController();
                controller.setCompetitors(competitors);
                break;
            case "pages/edit":
                controller = fxmlLoader.<EditController>getController();
                controller.setCompetitors(competitors);
                break;
            case "pages/view":
                controller = fxmlLoader.<ViewController>getController();
                controller.setCompetitors(competitors);
                break;
        }
        
        
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
}
