package edu.fiuba.algo3.vistas;

import javafx.scene.control.Button;

public class VistaCarta extends Button {

    public VistaCarta(String nombre){
        super(nombre);

        this.setPrefSize(45,70);

        this.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 1; -fx-font-weight: bold;");

        this.setOnAction(e -> {
            System.out.println("Carta seleccionada: " + nombre);
        });
    }
}
