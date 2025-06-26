package edu.fiuba.algo3.vistas.Contenedores;

import edu.fiuba.algo3.vistas.Individuales.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class VistaColumnaIzquierda extends VBox {
    private final VistaDatos infoJugador1;
    private final VistaDatos infoJugador2;

    public VistaColumnaIzquierda(VistaAtril vistaAtril1, VistaAtril vistaAtril2, VistaTurnos vistaTurnos, VistaPuntosJugador puntosJ1, VistaPuntosJugador puntosJ2) {
        super(20);
        this.setAlignment(Pos.CENTER_LEFT);
        this.setPadding(new Insets(20));
        this.setMaxWidth(180);

        //VistaPuntosJugador puntosJugador1 = new VistaPuntosJugador(vistaAtril1);
        //VistaPuntosJugador puntosJugador2 = new VistaPuntosJugador(vistaAtril2);

        this.infoJugador2 = new VistaDatos("Jugador 2", puntosJ2);
        this.infoJugador1 = new VistaDatos("Jugador 1", puntosJ1);

        VistaSeccionEspecial especiales = new VistaSeccionEspecial("Especiales");

        this.getChildren().addAll(vistaTurnos,infoJugador2, especiales, infoJugador1);
    }

    public VistaPuntosJugador getPuntosJugador1(){
        return infoJugador1.getVistaPuntosJugador();
    }
    public VistaPuntosJugador getPuntosJugador2(){
        return infoJugador2.getVistaPuntosJugador();
    }
}

