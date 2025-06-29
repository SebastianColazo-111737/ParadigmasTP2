package edu.fiuba.algo3.vistas.Contenedores;

import edu.fiuba.algo3.ControladorTurnos;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.vistas.Individuales.VistaDescarte;
import edu.fiuba.algo3.vistas.Individuales.VistaMazo;
import edu.fiuba.algo3.vistas.OrdenadorSecciones;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;

import java.util.List;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class VistaJugador extends VBox {

    private final VistaMano vistaMano;

    public VistaJugador(Jugador jugador, boolean estaArriba, VistaMano vistaMano, VistaTurnos vistaTurnos, ControladorTurnos controladorTurnos){
        super(10);
        this.setAlignment(Pos.CENTER);

        this.vistaMano = new VistaMano(jugador.mano().getCartas(), carta -> {
            System.out.println("Se seleccionó: " + carta.nombre());
        });

        VBox secciones = construirVistaSecciones(jugador,estaArriba, vistaTurnos, controladorTurnos);
        Node contenedorDerecha = construirContenedorDerecha(jugador,estaArriba);

        BorderPane contenedor = new BorderPane();
        contenedor.setCenter(secciones);

        if (estaArriba) {
            contenedor.setTop(contenedorDerecha);
            BorderPane.setAlignment(contenedorDerecha, Pos.TOP_RIGHT);
        } else {
            contenedor.setBottom(contenedorDerecha);
            BorderPane.setAlignment(contenedorDerecha, Pos.BOTTOM_RIGHT);
        }
        this.getChildren().addAll(contenedor);
    }

    private VBox construirVistaSecciones(Jugador jugador, boolean estaArriba, VistaTurnos vistaTurnos, ControladorTurnos controladorTurnos) {
        List<Seccion> seccionesOrdenadas = OrdenadorSecciones.ordenar(jugador.atril().getSecciones(), estaArriba);

        VBox secciones = new VBox(5);
        secciones.setAlignment(Pos.CENTER);

        for (Seccion seccion : seccionesOrdenadas) {
            secciones.getChildren().add(new VistaSeccion(seccion, jugador, this.vistaMano, vistaTurnos, controladorTurnos));
        }
        return secciones;
    }

    private Node construirContenedorDerecha(Jugador jugador, boolean estaArriba) {
        VistaDescarte descarte = new VistaDescarte("Pila Descarte");
        VistaMazo mazo = new VistaMazo("Mazo");

        HBox contenedorLateral = new HBox(40, descarte, mazo);
        contenedorLateral.setAlignment(Pos.CENTER_RIGHT);

        VBox contenedor = estaArriba
                ? new VBox(15, contenedorLateral, this.vistaMano)
                : new VBox(15, this.vistaMano, contenedorLateral);
        return contenedor;
    }
}


