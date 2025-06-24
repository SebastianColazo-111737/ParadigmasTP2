package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vistas.Contenedores.*;
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
    public Lienzo(Jugador jugador1, Jugador jugador2) {
        VistaMano vistaManoJugador1 = new VistaMano(jugador1.mano().getCartas(), carta -> {});
        VistaMano vistaManoJugador2 = new VistaMano(jugador2.mano().getCartas(), carta -> {});

        VistaAtril vistaAtrilJugador2 = new VistaAtril(jugador2.atril(), true, jugador2, vistaManoJugador2);
        VistaAtril vistaAtrilJugador1 = new VistaAtril(jugador1.atril(), false, jugador1, vistaManoJugador1);

        VistaJugador vistaJugador2 = new VistaJugador(jugador2, true, vistaManoJugador2);
        VistaJugador vistaJugador1 = new VistaJugador(jugador1, false, vistaManoJugador1);

        VBox tablero = new VBox(20, vistaJugador2, vistaJugador1);
        tablero.setAlignment(Pos.CENTER);

        VistaColumnaIzquierda columnaIzquierda = new VistaColumnaIzquierda(vistaAtrilJugador1, vistaAtrilJugador2);

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
