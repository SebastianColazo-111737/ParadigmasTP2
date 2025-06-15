package edu.fiuba.algo3.vistas;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import java.util.List;

public class VistaJugador extends VBox {
    public VistaJugador(String nombreJugador, boolean estaArriba){
        super(10);

        Label nombre = new Label(nombreJugador);
        nombre.setStyle("-fx-font-weight: bold;");

        List<String> ordenSecciones = estaArriba
                ? List.of("ASEDIO", "DISTANCIA", "CUERPO")
                : List.of("CUERPO", "DISTANCIA", "ASEDIO");

        VBox secciones = new VBox(5);
        for(String nombreSeccion : ordenSecciones){
            secciones.getChildren().add(new VistaSeccion(nombreSeccion));
        }
        secciones.setAlignment(Pos.CENTER);

        VistaDescarte descarte = new VistaDescarte("Pila Descarte");

        BorderPane contenedor = new BorderPane();
        contenedor.setCenter(secciones);
        //Ver como sacar estos if's, a lo mejor otra logica tipo duplicar VistaJugador o sino hacer VistaJugador1 y VistaJugador2
        if (estaArriba) {
            contenedor.setTop(descarte);
            BorderPane.setAlignment(descarte, Pos.TOP_RIGHT);
            BorderPane.setMargin(descarte, new Insets(10, 10, 10, 10));
        } else {
            contenedor.setBottom(descarte);
            BorderPane.setAlignment(descarte, Pos.BOTTOM_RIGHT);
            BorderPane.setMargin(descarte, new Insets(10, 10, 10, 10));
        }

        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(nombre, contenedor);
    }
}
