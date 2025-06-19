package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.utilidades.Paths;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class nombreJugadorController {
    @FXML private TextField campoNombre;
    private Juego juego;

    public void setJuego(Juego juego) {
        this.juego = juego;
    }


    public void confirmarNombre(ActionEvent event) throws Exception {
        juego.jugadorActual().setNombre(campoNombre.getText());

        FXMLLoader loader = new FXMLLoader(getClass().getResource(Paths.SELECCION_MAZO));
        AnchorPane root = loader.load();
        seleccionMazoController controlador = loader.getController();
        controlador.setJuego(juego);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}
