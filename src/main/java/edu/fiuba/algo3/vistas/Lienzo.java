package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.ControladorTurnos;
import edu.fiuba.algo3.modelo.juego.Gwent;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vistas.Contenedores.*;
import edu.fiuba.algo3.vistas.Individuales.VistaDescarte;
import edu.fiuba.algo3.vistas.Contenedores.VistaTurnos;
import edu.fiuba.algo3.vistas.Individuales.VistaMazo;
import edu.fiuba.algo3.vistas.Individuales.VistaPuntosJugador;
import edu.fiuba.algo3.vistas.Individuales.VistaSeccionEspecial;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.Node;

public class Lienzo extends StackPane {

    public Lienzo(String nomJ1, String nomJ2,Jugador jugador1, Jugador jugador2, Gwent juego, ControladorTurnos controladorTurnos) {

        //Creacion de las VistasMano
        VistaMano vistaManoJugador1 = new VistaMano(jugador1.mano(), jugador1.mano().getCartas());
        VistaMano vistaManoJugador2 = new VistaMano(jugador2.mano(), jugador2.mano().getCartas());

        //Creacion de VistaTurnos
        VistaTurnos vistaTurnos = new VistaTurnos(juego, jugador1,jugador2, vistaManoJugador1, vistaManoJugador2, controladorTurnos);

        VistaDescarte vistaDescarteJ1 = new VistaDescarte("Descarte\n Jugador1", jugador1);
        VistaDescarte vistaDescarteJ2 = new VistaDescarte("Descarte\n Jugador2",jugador2);

        //Creacion de los VistaAtril
        VistaAtril vistaAtrilJugador2 = new VistaAtril(jugador2.atril(), true, jugador2, vistaManoJugador2, vistaTurnos, controladorTurnos, vistaDescarteJ2);
        VistaAtril vistaAtrilJugador1 = new VistaAtril(jugador1.atril(), false, jugador1, vistaManoJugador1, vistaTurnos, controladorTurnos,vistaDescarteJ1);

        //Crear VistaPuntosJugador
        VistaPuntosJugador puntosJugador1 =  new VistaPuntosJugador(vistaAtrilJugador1);
        VistaPuntosJugador puntosJugador2 =  new VistaPuntosJugador(vistaAtrilJugador2);

        //Creacion de los VistaJugador
        VistaJugador vistaJugador2 = new VistaJugador(jugador2, true, vistaTurnos, controladorTurnos,vistaDescarteJ2);
        VistaJugador vistaJugador1 = new VistaJugador(jugador1, false, vistaTurnos, controladorTurnos,vistaDescarteJ1);

        //Creacion VistaSeccionEspeciales
        VistaSeccionEspecial vistaSeccionEspecial = new VistaSeccionEspecial("Especiales Activas:",jugador1.atril(),jugador2.atril());

        //Creacion de la columnaIzquierda
        VistaColumnaIzquierda columnaIzquierda = new VistaColumnaIzquierda(nomJ1,nomJ2,vistaTurnos, puntosJugador1,puntosJugador2, vistaSeccionEspecial);

        controladorTurnos.setVistas(vistaAtrilJugador1, vistaAtrilJugador2, puntosJugador1, puntosJugador2);

        //Creacion del tablero
        VBox tablero = new VBox(20, vistaJugador2, vistaJugador1);
        tablero.setAlignment(Pos.CENTER);
        tablero.setMinWidth(750);
        tablero.setMinHeight(750);

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

        this.setStyle("-fx-background-color: #FFDAB9;");
        this.getChildren().add(contenedor);
        this.setPadding(new Insets(20));
    }
}
