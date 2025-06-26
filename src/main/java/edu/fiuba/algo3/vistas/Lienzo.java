package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.ControladorTurnos;
import edu.fiuba.algo3.modelo.juego.Gwent;
import edu.fiuba.algo3.modelo.jugador.Jugador;
<<<<<<< interfaz-grafica
import edu.fiuba.algo3.vistas.Contenedores.*;
import edu.fiuba.algo3.vistas.Individuales.VistaDescarte;
import edu.fiuba.algo3.vistas.Individuales.VistaMazo;
import edu.fiuba.algo3.vistas.Contenedores.VistaTurnos;
import edu.fiuba.algo3.vistas.Individuales.VistaPuntosJugador;
=======
import edu.fiuba.algo3.vistas.Contenedores.ContenedorTablero;
import edu.fiuba.algo3.vistas.Contenedores.VistaColumnaIzquierda;
import edu.fiuba.algo3.vistas.Contenedores.VistaDatos;
import edu.fiuba.algo3.vistas.Contenedores.VistaJugador;
import edu.fiuba.algo3.vistas.Individuales.VistaDescarte;
import edu.fiuba.algo3.vistas.Individuales.VistaMazo;
import edu.fiuba.algo3.vistas.Individuales.VistaSeccionEspecial;
import javafx.scene.image.Image;
>>>>>>> union-de-interfaces-forzada
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.Node;

import java.util.function.BiConsumer;

public class Lienzo extends StackPane {
<<<<<<< interfaz-grafica
    private VistaTurnos vistaTurnos;
=======
    public Lienzo(Jugador jugador1, Jugador jugador2, BiConsumer<String, Image> onMostrarDescripcion) {
        VistaJugador vistaJugador2 = new VistaJugador(jugador2, true, onMostrarDescripcion);
        VistaJugador vistaJugador1 = new VistaJugador(jugador1, false, onMostrarDescripcion);
>>>>>>> union-de-interfaces-forzada

    public Lienzo(Jugador jugador1, Jugador jugador2, Gwent juego, ControladorTurnos controladorTurnos) {

        //Creacion de las VistasMano
        VistaMano vistaManoJugador1 = new VistaMano(jugador1.mano().getCartas(), carta -> {});
        VistaMano vistaManoJugador2 = new VistaMano(jugador2.mano().getCartas(), carta -> {});

        //Creacion de VistaTurnos
        VistaTurnos vistaTurnos = new VistaTurnos(juego, jugador1,jugador2, vistaManoJugador1, vistaManoJugador2, controladorTurnos);

        //Creacion de los VistaAtril
        VistaAtril vistaAtrilJugador2 = new VistaAtril(jugador2.atril(), true, jugador2, vistaManoJugador2, vistaTurnos, controladorTurnos);
        VistaAtril vistaAtrilJugador1 = new VistaAtril(jugador1.atril(), false, jugador1, vistaManoJugador1, vistaTurnos, controladorTurnos);

        //Crear VistaPuntosJugador
        VistaPuntosJugador puntosJugador1 =  new VistaPuntosJugador(vistaAtrilJugador1);
        VistaPuntosJugador puntosJugador2 =  new VistaPuntosJugador(vistaAtrilJugador2);

        //Creacion de los VistaJugador
        VistaJugador vistaJugador2 = new VistaJugador(jugador2, true, vistaManoJugador2, vistaTurnos, controladorTurnos);
        VistaJugador vistaJugador1 = new VistaJugador(jugador1, false, vistaManoJugador1, vistaTurnos, controladorTurnos);

        //Creacion de la columnaIzquierda
        VistaColumnaIzquierda columnaIzquierda = new VistaColumnaIzquierda(vistaAtrilJugador1, vistaAtrilJugador2, vistaTurnos, puntosJugador1,puntosJugador2);

        controladorTurnos.setVistas(vistaAtrilJugador1, vistaAtrilJugador2, puntosJugador1, puntosJugador2);

        //Creacion del tablero
        VBox tablero = new VBox(20, vistaJugador2, vistaJugador1);
        tablero.setAlignment(Pos.CENTER);

        //Union del tablero con la columnaIzquierda
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
