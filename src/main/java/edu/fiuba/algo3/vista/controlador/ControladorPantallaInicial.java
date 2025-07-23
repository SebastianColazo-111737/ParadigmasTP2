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

    public String botonEstiloNormal() {
        return "-fx-font-size: 18px; -fx-padding: 10px 20px; -fx-background-color: #dddddd; -fx-text-fill: black;";
    }

    public String botonEstiloHover() {
        return "-fx-font-size: 18px; -fx-padding: 10px 20px; -fx-background-color: #aaaaaa; -fx-text-fill: black;";
    }
}
