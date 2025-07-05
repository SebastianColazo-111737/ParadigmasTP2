package edu.fiuba.algo3.vistas.Individuales;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.List;
import java.util.function.Consumer;

public class VistaDescarte extends StackPane{
    private static VistaDescarte seleccionado = null;
    private Rectangle fondo;
    private final Jugador jugador;

    public VistaDescarte(String nombre, Jugador jugador){
        this.jugador = jugador;

        fondo = new Rectangle(90,120);
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

