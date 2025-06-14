package edu.fiuba.algo3.vistas;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class Lienzo extends BorderPane {
    public Lienzo(){
        Label jugador2 = new Label("ACA VA EL JUGADOR 2");
        this.setTop(jugador2);

        Label separador = new Label("ACA VA EL SEPARADOR");
        this.setCenter(separador);

        Label jugador1 = new Label("ACA VA EL JUGADOR 1");
        this.setBottom(jugador1);
    }
}
