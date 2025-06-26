package edu.fiuba.algo3.vistas.Contenedores;

import edu.fiuba.algo3.vistas.Individuales.VistaPuntos;
import edu.fiuba.algo3.vistas.Individuales.VistaPuntosJugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaDatos extends StackPane {

    private VistaPuntosJugador vistaPuntosJugador;

    public VistaDatos(String nombre, VistaPuntosJugador vistaPuntosJugador) {
        Rectangle seccion = new Rectangle(200,100);
        seccion.setFill(Color.LIGHTCYAN);
        seccion.setStroke(Color.BLACK);

        Label etiqueta = new Label(nombre);
        StackPane rectanguloConTexto = new StackPane(seccion, etiqueta);

        this.vistaPuntosJugador = vistaPuntosJugador;

        StackPane.setAlignment(vistaPuntosJugador, Pos.TOP_RIGHT);
        StackPane.setMargin(vistaPuntosJugador, new Insets(5,-205,0,0));

        this.getChildren().addAll(rectanguloConTexto, vistaPuntosJugador);
    }

    public VistaPuntosJugador getVistaPuntosJugador(){
        return this.vistaPuntosJugador;
    }

    public void actualizarPuntaje(int puntajeActualizado){
        vistaPuntosJugador.actualizarPuntaje(puntajeActualizado);
    }
}


