package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.vistas.Contenedores.VistaColumnaIzquierda;
import edu.fiuba.algo3.vistas.Contenedores.VistaDatos;
import edu.fiuba.algo3.vistas.Contenedores.VistaJugador;
import edu.fiuba.algo3.vistas.Individuales.VistaDescarte;
import edu.fiuba.algo3.vistas.Individuales.VistaMazo;
import edu.fiuba.algo3.vistas.Individuales.VistaSeccionEspecial;
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

        VistaColumnaIzquierda columnaIzquierda = new VistaColumnaIzquierda();

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
