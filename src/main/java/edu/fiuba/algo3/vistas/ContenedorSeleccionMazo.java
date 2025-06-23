package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Mazo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorSeleccionMazo extends VBox {

    public ContenedorSeleccionMazo(Stage stage, Juego juego) {
        this.setPrefSize(800, 600);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(30);
        this.setPadding(new Insets(40));

        Label titulo = new Label("ELIGE TU MAZO DE GUERRA");
        titulo.setFont(new Font(20));

        HBox contenedorBotones = new HBox(30);
        contenedorBotones.setAlignment(Pos.CENTER);

        String[] nombresMazos = {"MAZO1", "MAZO2", "MAZO3"};

        for (String nombre : nombresMazos) {
            Button boton = new Button(nombre);
            boton.setMinSize(104, 147);
            boton.setOnAction(e -> {
                juego.jugadorActual().setMazo(new Mazo(nombre));
                juego.siguienteJugador();

                if (!juego.juegoCompleto()) {
                    ContenedorNombreJugador contenedorNombre = new ContenedorNombreJugador(stage, juego, new Scene(new ContenedorSeleccionMazo(stage, juego), 600, 400));
                    stage.setScene(new Scene(contenedorNombre));
                } else {
                    ContenedorMenuPrincipal contenedorMenu = new ContenedorMenuPrincipal(stage, juego, null);
                    stage.setScene(new Scene(contenedorMenu));
                }
            });
            contenedorBotones.getChildren().add(boton);
        }

        this.getChildren().addAll(titulo, contenedorBotones);
    }
}