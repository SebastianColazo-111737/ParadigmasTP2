package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.juego.Gwent;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vistas.Contenedores.ContenedorMenuPrincipal;
import edu.fiuba.algo3.vistas.Contenedores.ContenedorSeleccionMazo;
import edu.fiuba.algo3.vistas.Contenedores.ContenedorTablero;
import edu.fiuba.algo3.vistas.Contenedores.ContenedorNombreJugador;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

/**
 * JavaFX App
 */

public class App extends Application {

    @Override
    public void start(Stage stage) {
        List<Jugador> jugadores = GeneradorJuego.crearJugadores();
        Gwent juego = new Gwent(jugadores.get(0),jugadores.get(1));
        ContenedorTablero contenedorTablero = new ContenedorTablero(stage, juego);
        Scene escenaTablero = new Scene(contenedorTablero);
        ContenedorSeleccionMazo contenedorMazo = new ContenedorSeleccionMazo(stage, juego, escenaTablero);
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