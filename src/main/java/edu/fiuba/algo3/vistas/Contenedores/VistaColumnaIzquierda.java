package edu.fiuba.algo3.vistas.Contenedores;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.atril.Atril;
import edu.fiuba.algo3.vistas.Individuales.VistaPuntos;
import edu.fiuba.algo3.vistas.Individuales.VistaPuntosJugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import edu.fiuba.algo3.vistas.Contenedores.VistaDatos;
import edu.fiuba.algo3.vistas.Individuales.VistaSeccionEspecial;

public class VistaColumnaIzquierda extends VBox {
    private final VistaDatos infoJugador1;
    private final VistaDatos infoJugador2;

    public VistaColumnaIzquierda(VistaAtril vistaAtril1, VistaAtril vistaAtril2) {
        super(20);
        this.setAlignment(Pos.CENTER_LEFT);
        this.setPadding(new Insets(20));
        this.setMaxWidth(180);

        VistaPuntosJugador puntosJugador1 = new VistaPuntosJugador(vistaAtril1);
        VistaPuntosJugador puntosJugador2 = new VistaPuntosJugador(vistaAtril2);

        this.infoJugador2 = new VistaDatos("Jugador 2", puntosJugador2);
        this.infoJugador1 = new VistaDatos("Jugador 1", puntosJugador1);

        VistaSeccionEspecial especiales = new VistaSeccionEspecial("Especiales");

        this.getChildren().addAll(infoJugador2, especiales, infoJugador1);
    }
}
/*public class VistaColumnaIzquierda extends VBox{
    private final VistaDatos infoJugador1;
    private final VistaDatos infoJugador2;

    private final VistaAtril vistaAtril1;
    private final VistaAtril vistaAtril2;

    public VistaColumnaIzquierda(Jugador jugador1, VistaMano vistaMano1, Jugador jugador2, VistaMano vistaMano2) {
        super(20);
        this.setAlignment(Pos.CENTER_LEFT);
        this.setPadding(new Insets(20));
        this.setMaxWidth(180);

        //Creo aca directamente VistaAtril
        this.vistaAtril1 = new VistaAtril(jugador1.atril(),false,jugador1,vistaMano1);
        this.vistaAtril2 = new VistaAtril(jugador2.atril(),true,jugador2,vistaMano2);

        //Creo VistaPuntosJugador
        VistaPuntosJugador puntosJugador1 = new VistaPuntosJugador(vistaAtril1.PuntajeTotalAtril());
        VistaPuntosJugador puntosJugador2 = new VistaPuntosJugador(vistaAtril2.PuntajeTotalAtril());

        //Creo VistaDatos
        this.infoJugador2 = new VistaDatos("Jugador 2",puntosJugador2);
        this.infoJugador1 = new VistaDatos("Jugador 1",puntosJugador1);

        //Para las cartas especiales
        VistaSeccionEspecial especiales = new VistaSeccionEspecial("Especiales");

        this.getChildren().addAll(infoJugador2, especiales, infoJugador1);
    }

    public void actualizaPuntajes(){
        infoJugador1.actualizarPuntaje(vistaAtril1.PuntajeTotalAtril());
        infoJugador2.actualizarPuntaje(vistaAtril2.PuntajeTotalAtril());
    }
}*/
