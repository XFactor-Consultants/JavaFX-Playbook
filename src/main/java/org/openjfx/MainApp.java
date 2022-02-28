package org.openjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent menu = FXMLLoader.load(getClass().getResource("scenes/menu.fxml"));

        Scene menuScene = new Scene(menu);

        menuScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        
        stage.setTitle("NoteApp");
        stage.setScene(menuScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
