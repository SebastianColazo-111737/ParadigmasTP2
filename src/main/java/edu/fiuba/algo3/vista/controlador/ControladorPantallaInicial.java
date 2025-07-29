package edu.fiuba.algo3.vista.controlador;


import edu.fiuba.algo3.vista.pantallas.PantallaCrearJugadores;
import javafx.stage.Stage;


public class ControladorPantallaInicial {
    private final Stage stage;
    public ControladorPantallaInicial(Stage stage) {
        this.stage = stage;
    }
    public void iniciarPartida() {
        new PantallaCrearJugadores(this.stage);
    }
}
