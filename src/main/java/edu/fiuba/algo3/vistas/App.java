package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.SystemInfo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Lienzo lienzo = new Lienzo();
        Scene scene = new Scene(lienzo, 1000, 1000);

        stage.setTitle("Gwent-Paradigmas");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}