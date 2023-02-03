package com.r0r5chach;

import java.io.File;
import java.io.IOException;

import static com.r0r5chach.CompetitorList.createErrorLog;
import com.r0r5chach.controllers.Controller;
import com.r0r5chach.controllers.EditController;
import com.r0r5chach.controllers.MainController;
import com.r0r5chach.controllers.ReportController;
import com.r0r5chach.controllers.ViewController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Manager extends Application {

    private static Scene scene;
    public static Stage stage;
    private static CompetitorList competitors;

    private static Controller controller;

    @Override
    public void start(Stage stage) throws IOException {
        competitors = createList();
        controller = null;
        scene = new Scene(loadFXML("main"), 640, 480);
        Manager.stage = stage;
        Manager.stage.setScene(scene);
        Manager.stage.show();
    }

    @Override
    public void stop() {
        try {
            competitors.createReportFile();
        }
        catch (IOException e) {
            createErrorLog(e, "src/main/resources/com/r0r5chach/log.txt");
        }
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Manager.class.getResource(fxml + ".fxml"));
        Parent root = fxmlLoader.load();
        if (controller != null) {
            competitors = controller.getCompetitors();
        }
        
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
            case "pages/report":
                controller = fxmlLoader.<ReportController>getController();
                controller.setCompetitors(competitors);
                break;

        }
        
        
        return root;
    }

    public static void main(String[] args) {
        launch();
    }

    private CompetitorList createList() {
        CompetitorList competitors = null;
        File valorantPlayers = new File("src/main/resources/com/r0r5chach/valorantPlayers.txt");
        File r6Players = new File("src/main/resources/com/r0r5chach/r6Players.txt");
        try {
            competitors = new CompetitorList();
            competitors.readCompetitors(valorantPlayers);
            competitors.readCompetitors(r6Players);
        }
        catch (Exception e) {
            createErrorLog(e, "src/main/resources/com/r0r5chach/log.txt");
        }
        return competitors;
    }
}
