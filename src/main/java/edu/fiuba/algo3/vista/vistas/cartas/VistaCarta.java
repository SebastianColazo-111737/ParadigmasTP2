package edu.fiuba.algo3.vista.vistas.cartas;

import javafx.scene.layout.StackPane;

public abstract class VistaCarta extends StackPane {

    public abstract StackPane getVentanaDetalle(Boolean sePuedeJugar);

    protected String estiloBotonNormal() {
        return "-fx-background-color: #333333;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-font-family: 'Georgia';" +
                "-fx-font-size: 12px;" +
                "-fx-background-radius: 12;" +
                "-fx-border-radius: 12;" +
                "-fx-border-color: gold;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, black, 10, 0.5, 0, 2);";
    }

    protected String estiloBotonHover() {
        return "-fx-background-color: #555555;" +
                "-fx-text-fill: gold;" +
                "-fx-font-weight: bold;" +
                "-fx-font-family: 'Georgia';" +
                "-fx-font-size: 12px;" +
                "-fx-background-radius: 12;" +
                "-fx-border-radius: 12;" +
                "-fx-border-color: gold;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, gold, 12, 0.6, 0, 0);";
    }
}
