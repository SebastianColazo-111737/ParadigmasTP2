package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.utilidades.Paths;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage){
        Juego juego = new Juego();

        ContenedorSeleccionMazo contenedorMazo = new ContenedorSeleccionMazo(stage, juego);
        Scene escenaMazo = new Scene(contenedorMazo);
        ContenedorNombreJugador contenedorNombre = new ContenedorNombreJugador(stage, juego, escenaMazo);
        Scene escenaNombre = new Scene(contenedorNombre);
        ContenedorMenuPrincipal contenedorMenu = new ContenedorMenuPrincipal(stage, juego, escenaNombre);
        Scene escenaMenu = new Scene(contenedorMenu);

        stage.setWidth(800);
        stage.setHeight(600);

        stage.setScene(escenaMenu);
        stage.setTitle("GWENT");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}