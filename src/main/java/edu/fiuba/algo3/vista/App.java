package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.pantallas.PantallaInicial;
import edu.fiuba.algo3.vista.pantallas.PantallaJuego;
import javafx.application.Application;

import javafx.scene.image.Image;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    @Override
    public void start(Stage stage) {
        new PantallaInicial(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}