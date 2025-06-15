package edu.fiuba.algo3.vistas;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.*;




public class Lienzo extends BorderPane {
    public Lienzo(){

        Label jugador2 = new Label("ACA VA EL JUGADOR 2");
        this.setTop(jugador2);

        VBox seccionesJugador2 = new VBox(10, new VistaSeccion("ASEDIO"),new VistaSeccion("DISTANCIA"),new VistaSeccion("CUERPO"));
        seccionesJugador2.setAlignment(Pos.CENTER);

        VBox seccionesJugador1 = new VBox(10, new VistaSeccion("CUERPO"),new VistaSeccion("DISTANCIA"),new VistaSeccion("ASEDIO"));
        seccionesJugador1.setAlignment(Pos.CENTER);

        VBox centroDelTablero = new VBox(26, seccionesJugador2, seccionesJugador1);
        centroDelTablero.setAlignment(Pos.CENTER);

        VBox seccionCartasEspeciales = new VBox(new VistaSeccionEspecial("Especiales"));
        seccionCartasEspeciales.setAlignment(Pos.CENTER);
        seccionCartasEspeciales.setPadding(new Insets(0, 10, 0, 10));

        StackPane izquierda = new StackPane(seccionCartasEspeciales);
        izquierda.setPrefWidth(0);
        izquierda.setAlignment(Pos.CENTER_LEFT);

        this.setLeft(izquierda);
        this.setCenter(centroDelTablero);

        Label jugador1 = new Label("ACA VA EL JUGADOR 1");
        this.setBottom(jugador1);
    }
}
