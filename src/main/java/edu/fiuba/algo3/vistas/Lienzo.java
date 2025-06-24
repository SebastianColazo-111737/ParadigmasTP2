package edu.fiuba.algo3.vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Lienzo extends VBox {
    private final ContenedorTablero contenedorTablero;

    public Lienzo(ContenedorTablero contenedorTablero) {
        this.contenedorTablero = contenedorTablero;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        HBox filaCartas = new HBox(20);
        filaCartas.setAlignment(Pos.CENTER);

        // BOTONES INPROVISADOS PARA QUE FUNQUE
        Button carta1 = crearBotonCarta("Espadachin", "/espadachin.png");
        Button carta2 = crearBotonCarta("Arquero", "/arquero.png");
        Button carta3 = crearBotonCarta("Bestia", "/bestia.png");

        filaCartas.getChildren().addAll(carta1, carta2, carta3);
        this.getChildren().add(filaCartas);
    }

    private Button crearBotonCarta(String nombre, String rutaImagen) {
        Button boton = new Button(nombre);
        boton.setMinSize(74, 117);
        boton.setOnAction(e -> {
            Image imagen = new Image(getClass().getResource(rutaImagen).toExternalForm());
            contenedorTablero.mostrarVistaDescripcion(nombre, imagen);
        });
        return boton;
    }
}
