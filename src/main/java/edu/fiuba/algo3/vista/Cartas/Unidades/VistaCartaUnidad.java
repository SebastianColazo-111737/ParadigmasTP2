package edu.fiuba.algo3.vista.Cartas.Unidades;

import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.vista.Cartas.VistaCarta;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.List;

public class VistaCartaUnidad extends VistaCarta {

    private Unidad unidadModelo;

    public VistaCartaUnidad(Unidad unidad, List<String> modificadores, List<String> posiciones) {

        this.unidadModelo = unidad;

        String nombre = unidad.getNombre();
        int puntaje = unidad.getPuntaje().getPuntajeActual();

        Text textoNombre = new Text(nombre + "\n\n" );
        textoNombre.setFont(Font.font(14));

        Text textoPuntaje = new Text(String.valueOf(puntaje + "\n" ));
        textoPuntaje.setFont(Font.font(24));  // Más grande

        Text textoResto = new Text("\n");
        if (!modificadores.isEmpty()) {
            textoResto = new Text(String.join(", ", modificadores) + "\n" );
        }

        Text textoPosiciones = new Text(formatearPosiciones(posiciones));
        textoPosiciones.setFont(Font.font(14));

        TextFlow textFlow = new TextFlow(textoNombre, textoPuntaje, textoResto, textoPosiciones);
        this.getChildren().add(textFlow);

        this.setStyle("-fx-border-color: black; -fx-padding: 10; -fx-background-color: lightgray;");
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
