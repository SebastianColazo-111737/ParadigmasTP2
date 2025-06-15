package edu.fiuba.algo3.vistas;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.BorderPane;
import org.w3c.dom.css.Rect;

public class VistaSeccionEspecial extends StackPane {

    public VistaSeccionEspecial(String nombre){
        Rectangle seccion = new Rectangle(200,60);
        seccion.setFill(Color.LIGHTGOLDENRODYELLOW);
        seccion.setStroke(Color.BLACK);

        Label etiqueta = new Label(nombre);
        this.getChildren().addAll(seccion,etiqueta);
    }
}
