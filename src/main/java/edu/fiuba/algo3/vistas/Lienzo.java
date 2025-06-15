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
        VistaJugador jugador2 = new VistaJugador("",true);
        VistaJugador jugador1 = new VistaJugador("",false);

        VBox centroDelTablero = new VBox(8, jugador2, jugador1);
        centroDelTablero.setAlignment(Pos.CENTER);

        VBox columnaIzquierda = new VBox();
        columnaIzquierda.setSpacing(80);
        columnaIzquierda.setAlignment(Pos.CENTER_LEFT);
        columnaIzquierda.setPadding(new Insets(40));

        VistaSeccionEspecial especiales = new VistaSeccionEspecial("Epeciales");
        VistaDatos infoJugador2 = new VistaDatos("DatosJugador2");
        VistaDatos infoJugador1 = new VistaDatos("DatosJugador1");
        columnaIzquierda.getChildren().addAll(infoJugador2,especiales ,infoJugador1);

        this.setLeft(columnaIzquierda);
        this.setCenter(centroDelTablero);
    }
}
