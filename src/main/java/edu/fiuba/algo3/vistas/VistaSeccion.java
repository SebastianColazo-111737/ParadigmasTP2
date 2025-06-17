package edu.fiuba.algo3.vistas;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.BorderPane;
import org.w3c.dom.css.Rect;
import javafx.scene.shape.Circle;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;

public class VistaSeccion extends StackPane {

    public VistaSeccion(String nombre){
        VistaPuntos puntos = new VistaPuntos();

        Rectangle seccion = new Rectangle(240,70);
        seccion.setFill(Color.LIGHTGRAY);
        seccion.setStroke(Color.BLACK);

        Label etiqueta = new Label(nombre);
        StackPane rectanguloConTexto = new StackPane(seccion, etiqueta);

        HBox contenido = new HBox(-5, puntos, rectanguloConTexto);
        contenido.setAlignment(Pos.CENTER_LEFT);

        this.getChildren().add(contenido);
    }
}
