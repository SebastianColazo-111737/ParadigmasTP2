package edu.fiuba.algo3.vistas.Contenedores;

import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.modelo.posiciones.Asedio;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posiciones.Distancia;
import edu.fiuba.algo3.vistas.Individuales.VistaDescarte;
import edu.fiuba.algo3.vistas.Individuales.VistaMazo;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class VistaJugador extends VBox {

    public VistaJugador(Jugador jugador, boolean estaArriba){
        super(10);
        this.setAlignment(Pos.CENTER);

        VBox secciones = construirVistaSecciones(jugador,estaArriba);
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

    private VBox construirVistaSecciones(Jugador jugador, boolean estaArriba) {
        List<Seccion> seccionesOrdenadas = jugador.atril().getSecciones()
                .stream()
                .sorted(Comparator.comparingInt(seccion -> ordenSeccion(seccion, estaArriba)))
                .collect(Collectors.toList());

        VBox secciones = new VBox(5);
        secciones.setAlignment(Pos.CENTER);

        for (Seccion seccion : seccionesOrdenadas) {
            secciones.getChildren().add(new VistaSeccion(seccion));
        }

        return secciones;
    }

    private Node construirContenedorDerecha(Jugador jugador, boolean estaArriba) {
        VistaDescarte descarte = new VistaDescarte("Pila Descarte");
        VistaMazo mazo = new VistaMazo("Mazo");

        VistaMano vistaMano = new VistaMano(jugador.mano().getCartas(), carta -> {
            System.out.println("Se seleccionó: " + carta.nombre());
        });

        HBox contenedorLateral = new HBox(40, descarte, mazo);
        contenedorLateral.setAlignment(Pos.CENTER_RIGHT);

        VBox contenedor = estaArriba
                ? new VBox(10, contenedorLateral, vistaMano)
                : new VBox(10, vistaMano, contenedorLateral);

        return contenedor;
    }

    private int ordenSeccion(Seccion seccion, boolean estaArriba) {
        if (seccion.getPosicion() instanceof Asedio) {
            return estaArriba ? 0 : 2;
        } else if (seccion.getPosicion() instanceof Distancia) {
            return 1;
        } else if (seccion.getPosicion() instanceof CuerpoACuerpo) {
            return estaArriba ? 2 : 0;
        }
        return 3;
    }
}


