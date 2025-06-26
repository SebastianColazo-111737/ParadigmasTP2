package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.juego.Gwent;
import edu.fiuba.algo3.modelo.jugador.Jugador;
//import edu.fiuba.algo3.vistas.Contenedores.ContenedorMenuPrincipal;
import edu.fiuba.algo3.vistas.Contenedores.ContenedorNombreJugador;
import edu.fiuba.algo3.vistas.Contenedores.ContenedorSeleccionMazo;
import edu.fiuba.algo3.vistas.Contenedores.ContenedorTablero;
import edu.fiuba.algo3.vistas.Lienzo;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */

public class App extends Application {

    private Stage primerStage;

    @Override
    public void start(Stage stage){
        this.primerStage = stage;
        iniciarMenu();
    }

    // Inicia el menú de bienvenida
    private void iniciarMenu() {
        Button comenzar = new Button("¡Comenzar Juego!");
        comenzar.setOnAction(e -> iniciarJuego());

        VBox contenedor = new VBox(30, new Label("Bienvenido a GWENT"), comenzar);
        contenedor.setAlignment(Pos.CENTER);
        Scene escenaMenu = new Scene(contenedor, 800, 600);

        primerStage.setScene(escenaMenu);
        primerStage.setTitle("Gwent - Menú Principal");
        primerStage.show();
    }

    // Inicia el juego directamente
    private void iniciarJuego() {
        // Crear el juego desde GeneradorJuego
        Lienzo lienzo = GeneradorJuego.construirJuego();
        Scene escenaJuego = new Scene(lienzo, 1200, 1000);

        primerStage.setScene(escenaJuego);
        primerStage.setTitle("Gwent - Juego");
    }

    public static void main(String[] args) {
        launch();
    }
}
