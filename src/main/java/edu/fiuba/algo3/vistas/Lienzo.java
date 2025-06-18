package edu.fiuba.algo3.vistas;

import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.Node;

public class Lienzo extends StackPane {
    public Lienzo() {
        VistaJugador jugador2 = new VistaJugador("", true);
        VistaJugador jugador1 = new VistaJugador("", false);

        VBox tablero = new VBox(20, jugador2, jugador1);
        tablero.setAlignment(Pos.CENTER);

        VBox columnaIzquierda = new VBox(20);
        columnaIzquierda.setAlignment(Pos.CENTER_LEFT);
        columnaIzquierda.setPadding(new Insets(20));
        columnaIzquierda.setMaxWidth(180);

        VistaSeccionEspecial especiales = new VistaSeccionEspecial("Especiales");
        VistaDatos infoJugador2 = new VistaDatos("DatosJugador2");
        VistaDatos infoJugador1 = new VistaDatos("DatosJugador1");
        columnaIzquierda.getChildren().addAll(infoJugador2, especiales, infoJugador1);

        HBox contenedor = new HBox(40, columnaIzquierda, tablero);
        contenedor.setAlignment(Pos.CENTER);

        this.setOnMousePressed(e -> {
            Node target = (Node) e.getTarget();

            boolean clicFueraDeMazo = !(target instanceof VistaMazo) && !(target.getParent() instanceof VistaMazo);
            boolean clicFueraDeDescarte = !(target instanceof VistaDescarte) && !(target.getParent() instanceof VistaDescarte);

            if (clicFueraDeMazo) VistaMazo.limpiarSeccion();
            if (clicFueraDeDescarte) VistaDescarte.limpiarSeccion();
        });

        this.getChildren().add(contenedor);
        this.setPadding(new Insets(20));
    }
}
