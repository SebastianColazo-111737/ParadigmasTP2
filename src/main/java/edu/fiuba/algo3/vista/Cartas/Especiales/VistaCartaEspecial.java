package edu.fiuba.algo3.vista.Cartas.Especiales;

import edu.fiuba.algo3.modelo.carta.Carta;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.List;

public class VistaCartaEspecial extends StackPane {
    private Carta especialModelo;

    public VistaCartaEspecial(Carta especial, String descripcion, String tipo, List<String> posiciones) {

        this.especialModelo = especial;

        VBox contenedor = new VBox(5); // Espaciado entre líneas
        contenedor.setAlignment(Pos.CENTER);

        Label nombreLabel = new Label(especial.getNombre());
        nombreLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

        Label tipoLabel = new Label(tipo);
        tipoLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: darkred;");

        Label descripcionLabel = new Label(descripcion);
        descripcionLabel.setWrapText(true);
        descripcionLabel.setMaxWidth(120);
        descripcionLabel.setStyle("-fx-font-size: 11px;");

        Label posicionesLabel = new Label(formatearPosiciones(posiciones));
        posicionesLabel.setStyle("-fx-font-size: 16px;");

        contenedor.getChildren().addAll(nombreLabel, tipoLabel, descripcionLabel, posicionesLabel);
        this.getChildren().add(contenedor);

        this.setStyle("-fx-border-color: darkred; -fx-padding: 10; -fx-background-color: mistyrose;");
        this.setPrefWidth(140);
        this.setPrefHeight(200);
    }

    private static String formatearPosiciones(List<String> posiciones) {
        StringBuilder sb = new StringBuilder();
        for (String pos : posiciones) {
            switch (pos.toLowerCase()) {
                case "cuerpo a cuerpo": sb.append("🗡️ "); break;
                case "rango": sb.append("⋙ "); break;
                case "asedio": sb.append("🛡️ "); break;
                default: sb.append(" "); break;
            }
        }
        return sb.toString();
    }
}
