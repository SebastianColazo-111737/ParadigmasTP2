package edu.fiuba.algo3;

import edu.fiuba.algo3.vistas.Lienzo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Lienzo lienzo = GeneradorJuego.construirJuego();
        Scene scene = new Scene(lienzo, 1000, 1000);

        stage.setTitle("Gwent-Paradigmas");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}