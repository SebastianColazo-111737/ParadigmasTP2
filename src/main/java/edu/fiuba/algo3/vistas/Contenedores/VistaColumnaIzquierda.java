package edu.fiuba.algo3.vistas.Contenedores;

import edu.fiuba.algo3.vistas.Individuales.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class VistaColumnaIzquierda extends VBox {
    private final VistaDatos infoJugador1;
    private final VistaDatos infoJugador2;

    public VistaColumnaIzquierda(VistaTurnos vistaTurnos, VistaPuntosJugador puntosJ1, VistaPuntosJugador puntosJ2) {
        super(20);
        this.setAlignment(Pos.CENTER_LEFT);
        this.setPadding(new Insets(20));
        this.setMaxWidth(180);

        this.infoJugador2 = new VistaDatos("Ogro", puntosJ2);
        this.infoJugador1 = new VistaDatos("Guerrero", puntosJ1);

        this.getChildren().addAll(vistaTurnos,infoJugador2, infoJugador1,crearGuiaModificadores());
    }

    private VBox crearGuiaModificadores() {
        Label titulo = new Label("Guía de Modificadores:");
        titulo.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        VBox itemsGuia = new VBox(8);
        itemsGuia.setPadding(new Insets(5));

        itemsGuia.getChildren().addAll(
                crearItemGuia("Legendaria", "#FFD700"),
                crearItemGuia("Medico", "#8FBC8F"),
                crearItemGuia("Carta Unida", "#2E8B57"),
                crearItemGuia("Morale Boost", "#FFA07A"),
                crearItemGuia("Agil", "#DDA0DD"),
                crearItemGuia("Espia", "#A9A9A9"),
                crearItemGuia("Sin modificador", "#FFF8DC")
        );

        VBox infoColores = new VBox(14, titulo, itemsGuia);
        infoColores.setPadding(new Insets(10));
        infoColores.setStyle("-fx-background-color: lightgray; -fx-border-color: black;");
        infoColores.setMaxWidth(200);

        return infoColores;
    }

    private HBox crearItemGuia(String nombre, String colorHex) {
        Rectangle muestraColor = new Rectangle(20, 20);
        muestraColor.setFill(Color.web(colorHex));
        muestraColor.setStroke(Color.BLACK);

        Label etiqueta = new Label(nombre);
        etiqueta.setFont(Font.font("Arial", 16));

        HBox item = new HBox(10, muestraColor, etiqueta);
        item.setAlignment(Pos.CENTER_LEFT);
        return item;
    }
}