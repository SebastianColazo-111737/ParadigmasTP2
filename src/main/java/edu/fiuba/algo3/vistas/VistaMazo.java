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

public class VistaMazo extends StackPane{

    public VistaMazo(String nombre){
        Rectangle fondo = new Rectangle(70,120);
        fondo.setFill(Color.LIGHTSTEELBLUE);
        fondo.setStroke(Color.BLACK);

        Label etiqueta = new Label(nombre);
        this.getChildren().addAll(fondo,etiqueta);
    }
}



