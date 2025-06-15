package edu.fiuba.algo3.vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.BorderPane;
import org.w3c.dom.css.Rect;
import javafx.scene.shape.Circle;

public class VistaDatos extends StackPane {

    public VistaDatos(String nombre) {
        Rectangle seccion = new Rectangle(200,70);
        seccion.setFill(Color.LIGHTCYAN);
        seccion.setStroke(Color.BLACK);

        Label etiqueta = new Label(nombre);
        StackPane rectanguloConTexto = new StackPane(seccion, etiqueta);

        VistaPuntos Puntos = new VistaPuntos();

        StackPane.setAlignment(Puntos, Pos.TOP_RIGHT);
        StackPane.setMargin(Puntos, new Insets(5,-205,0,0));

        this.getChildren().addAll(rectanguloConTexto, Puntos);
    }
}


