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
/**
 * Class that contains the main method and starts the GUI
 * @author r0r5chach
 */
public class Manager extends Application {
    /**
     * Attribute that stores the GUI's scene
     */
    private static Scene scene;
    /**
     * Attribute that stores the GUI's stage
     */
    public static Stage stage;
    /**
     * Attribute that stores the program's competitors
     */
    private static CompetitorList competitors;
    /**
     * Attribute that stores the currently active controller
     */
    private static Controller controller;
    /**
     * Creates the GUI and competitor list, then sets the main View
     * @param stage the stage to use for the GUI
     * @throws IOException if the scene's FXML file cannot be found
     */
    @Override
    public void start(Stage stage) throws IOException {
        competitors = createList();
        controller = null;
        scene = new Scene(loadFXML("main"), 640, 480);
        Manager.stage = stage;
        Manager.stage.setScene(scene);
        Manager.stage.show();
    }
    /**
     * Stops the GUI and outputs a report file
     */
    @Override
    public void stop() {
        try {
            competitors.createReportFile("src/main/resources/com/r0r5chach");
        }
        catch (IOException e) {
            createErrorLog(e, "src/main/resources/com/r0r5chach/log.txt");
        }
    }
    /**
     * Change the root for the scene
     * @param fxml the view to be loaded
     * @throws IOException if the view file cannot be found
     */
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    /**
     * Load an FXML file
     * @param fxml the file to be loaded
     * @return the root to change the scene to
     * @throws IOException if the file cannot be found
     */
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
    /**
     * Launch the GUI
     * @param args the arguments passed to the program
     */
    public static void main(String[] args) {
        launch();
    }
    /**
     * Create the competitor list
     * @return the competitor list
     */
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