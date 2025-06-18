package edu.fiuba.algo3.vistas;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaMazo extends StackPane{
    private static VistaMazo seleccionado = null;
    private Rectangle fondo;

    public VistaMazo(String nombre){
        fondo = new Rectangle(70,120);
        fondo.setFill(Color.LIGHTSTEELBLUE);
        fondo.setStroke(Color.BLACK);
        fondo.setStrokeWidth(2);

        Label etiqueta = new Label(nombre);
        etiqueta.setStyle("-fx-font-weight: bold;");
        this.getChildren().addAll(fondo,etiqueta);

        this.setOnMouseClicked(e -> seleccionar());
    }

    private void seleccionar(){
        if(seleccionado !=null && seleccionado != this) seleccionado.deseleccionar();
        seleccionado = this;
        fondo.setStroke(Color.RED);
    }

    public void deseleccionar(){
        fondo.setStroke(Color.BLACK);
        if(seleccionado == this) seleccionado = null;
    }

    public static void limpiarSeccion(){
        if(seleccionado != null) seleccionado.deseleccionar();
    }
}



