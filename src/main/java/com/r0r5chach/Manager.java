package com.r0r5chach;
import java.io.File;

import javafx.application.Application;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import static com.r0r5chach.CompetitorList.createErrorLog;

public class Manager extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("main"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Manager.class.getResource(fxml + ".fxml"));
        Parent root = fxmlLoader.load();
        switch(fxml) {
            case "main":
            MainController controller = fxmlLoader.<MainController>getController();
            controller.setCompetitors(createList());
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
