package edu.fiuba.algo3.vista.controlador;


import edu.fiuba.algo3.vista.pantallas.PantallaJuego;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.stage.Stage;
import javafx.scene.control.Alert;


public class ControladorCrearJugadores {

    private  Stage stage;

    private  TextField inputNombreJ1;
    private  ImageView inputImagenJ1;

    private  TextField inputNombreJ2;
    private  ImageView inputImagenJ2;

    private  Button botonAceptar;


    private String nombreJ1;
    private Image imagenJ1;

    private String nombreJ2;
    private Image imagenJ2;

    public ControladorCrearJugadores(Stage stage,
                                         TextField inputNombreJ1, ImageView inputImagenJ1,
                                         TextField inputNombreJ2, ImageView inputImagenJ2,
                                         Button botonAceptar) {
        this.stage = stage;

        this.inputNombreJ1 = inputNombreJ1;
        this.inputImagenJ1 = inputImagenJ1;

        this.inputNombreJ2 = inputNombreJ2;
        this.inputImagenJ2 = inputImagenJ2;

        this.botonAceptar = botonAceptar;

        configurarEventos();
    }

    private void configurarEventos() {
        inputImagenJ1.imageProperty().addListener((obs, oldImg, newImg) -> {
            imagenJ1 = newImg;
        });

        inputImagenJ2.imageProperty().addListener((obs, oldImg, newImg) -> {
            imagenJ2 = newImg;
        });

        botonAceptar.setOnAction(e -> aceptar());
    }

    private void aceptar() {

        nombreJ1 = inputNombreJ1.getText().trim();
        nombreJ2 = inputNombreJ2.getText().trim();

        if (nombreJ1.isEmpty() || imagenJ1 == null) {
            mostrarAlerta("Faltan datos del Jugador 1");
            return;
        }

        if(nombreJ1.length() > 10){
            mostrarAlerta("Nombre invalido del Jugador 1");
            return;
        }

        if (nombreJ2.isEmpty() || imagenJ2 == null) {
            mostrarAlerta("Faltan datos del Jugador 2");
            return;
        }

        if(nombreJ1.length() > 10){
            mostrarAlerta("Nombre invalido del Jugador 2");
            return;
        }

        new PantallaJuego(stage, nombreJ1, imagenJ1, nombreJ2, imagenJ2);
    }

    private void mostrarAlerta(String mensaje) {
        new Alert(Alert.AlertType.WARNING, mensaje).showAndWait();
    }

}
