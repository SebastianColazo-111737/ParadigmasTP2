package edu.fiuba.algo3.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import edu.fiuba.algo3.modelo.Juego.Juego;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import edu.fiuba.algo3.utilidades.Paths;

public class menuPrincipalController {

    private static final Juego juego = new Juego();

    public void empezarJuego(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Paths.NOMBRE_JUGADOR));
        AnchorPane root = loader.load();
        nombreJugadorController controlador = loader.getController();
        controlador.setJuego(juego);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}
