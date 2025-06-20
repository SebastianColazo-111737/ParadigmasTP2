package edu.fiuba.algo3.vistas.Individuales;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaSeccionEspecial extends StackPane {

    public VistaSeccionEspecial(String nombre){
        Rectangle seccion = new Rectangle(200,70);
        seccion.setFill(Color.LIGHTGOLDENRODYELLOW);
        seccion.setStroke(Color.BLACK);

        Label etiqueta = new Label(nombre);
        StackPane rectanguloConTexto = new StackPane(seccion, etiqueta);

        VistaPuntos Puntos = new VistaPuntos();

        this.getChildren().addAll(rectanguloConTexto);
    }
}
//Reutilizo este para el cuadro de los datos de cada jugador