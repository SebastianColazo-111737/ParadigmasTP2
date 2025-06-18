package edu.fiuba.algo3.vistas;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
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
        VistaMazo mazo = new VistaMazo("Mazo");
        VistaMano vistaMano = new VistaMano(nombreCarta -> {
            System.out.println("Se selecciono: " + nombreCarta);
        });

        HBox contenedorLateral = new HBox(40,descarte,mazo);
        contenedorLateral.setAlignment(Pos.CENTER_RIGHT);

        VBox contenedorManoyMazo = estaArriba
                ? new VBox(10, contenedorLateral, vistaMano)
                : new VBox(10, vistaMano, contenedorLateral);

        BorderPane contenedor = new BorderPane();
        contenedor.setCenter(secciones);

        if (estaArriba) {
            contenedor.setTop(contenedorManoyMazo);
            BorderPane.setAlignment(contenedorManoyMazo, Pos.TOP_RIGHT);
        } else {
            contenedor.setBottom(contenedorManoyMazo);
            BorderPane.setAlignment(contenedorManoyMazo, Pos.BOTTOM_RIGHT);
        }

        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(nombre, contenedor);
    }
}


