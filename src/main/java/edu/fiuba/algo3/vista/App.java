package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.controlador.MusicJuego;
import edu.fiuba.algo3.vista.pantallas.PantallaInicial;
import javafx.application.Application;


import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    @Override
    public void start(Stage stage) {
        new MusicJuego("src/main/resources/sounds/ingame.wav");
        new PantallaInicial(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}