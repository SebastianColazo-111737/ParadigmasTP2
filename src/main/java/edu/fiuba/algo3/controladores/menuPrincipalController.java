package edu.fiuba.algo3.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class menuPrincipalController {
    @FXML
    private Label lblmensaje;

    @FXML
    void click(ActionEvent event) {
        lblmensaje.setText("Hola Mundo");
    }
}
