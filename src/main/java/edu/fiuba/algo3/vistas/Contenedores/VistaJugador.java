package edu.fiuba.algo3.vistas.Contenedores;

import edu.fiuba.algo3.ControladorTurnos;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.vistas.Individuales.VistaDescarte;
import edu.fiuba.algo3.vistas.Individuales.VistaMazo;
import edu.fiuba.algo3.vistas.OrdenadorSecciones;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;

import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import junit.framework.JUnit4TestAdapter;

public class VistaJugador extends VBox {

    private final VistaMano vistaMano;
    private final VistaDescarte vistaDescarte;

    public VistaJugador(Jugador jugador, boolean estaArriba, VistaTurnos vistaTurnos,
                        ControladorTurnos controladorTurnos, VistaDescarte vistaDescarte){
        super(10);
        this.setAlignment(Pos.CENTER);

        this.vistaDescarte = vistaDescarte;
        this.vistaMano = new VistaMano(jugador.mano(), jugador.mano().getCartas());

        VBox secciones = construirVistaSecciones(jugador, estaArriba, vistaTurnos, controladorTurnos);
        Node contenedorDerecha = construirContenedorDerecha(jugador, estaArriba);

        BorderPane contenedor = new BorderPane();
        contenedor.setCenter(secciones);
        contenedor.setRight(contenedorDerecha);

        VBox contenedorTotal = new VBox(10);
        contenedorTotal.setAlignment(Pos.CENTER);

        if (estaArriba) {
            contenedorTotal.getChildren().addAll(this.vistaMano, contenedor);
        } else {
            contenedorTotal.getChildren().addAll(contenedor, this.vistaMano);
        }

        this.getChildren().add(contenedorTotal);
    }

    private VBox construirVistaSecciones(Jugador jugador, boolean estaArriba, VistaTurnos vistaTurnos,
                                         ControladorTurnos controladorTurnos) {

        List<Seccion> seccionesOrdenadas = OrdenadorSecciones.ordenar(jugador.atril().getSecciones(), estaArriba);

        VBox secciones = new VBox(5);
        secciones.setAlignment(Pos.CENTER);

        for (Seccion seccion : seccionesOrdenadas) {
            secciones.getChildren().add(new VistaSeccion(seccion, jugador, this.vistaMano, vistaTurnos, controladorTurnos));
        }
        return secciones;
    }

    private Node construirContenedorDerecha(Jugador jugador, boolean estaArriba) {
        VBox contenedorLateral = new VBox(40);
        contenedorLateral.setAlignment(Pos.CENTER);
        contenedorLateral.setPadding(new Insets(10));

        if (estaArriba) {
            contenedorLateral.getChildren().addAll( new VistaMazo("MAZO J2", jugador.mazo()),this.vistaDescarte);
        } else {
            contenedorLateral.getChildren().addAll( this.vistaDescarte, new VistaMazo("MAZO J1", jugador.mazo()));
        }
        return contenedorLateral;
    }
}


