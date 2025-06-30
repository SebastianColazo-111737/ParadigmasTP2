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

    public VistaJugador(Jugador jugador, boolean estaArriba, VistaMano vistaMano, VistaTurnos vistaTurnos, ControladorTurnos controladorTurnos){
        super(10);
        this.setAlignment(Pos.CENTER);

        this.vistaMano = new VistaMano(jugador.mano().getCartas(), carta -> {
            System.out.println("Se seleccionó: " + carta.nombre());
        });

        VBox secciones = construirVistaSecciones(jugador, estaArriba, vistaTurnos, controladorTurnos);
        Node contenedorDerecha = construirContenedorDerecha(jugador, estaArriba);

        BorderPane contenedor = new BorderPane();
        contenedor.setCenter(secciones);
        contenedor.setRight(contenedorDerecha); // <- CAMBIO CLAVE

        VBox contenedorTotal = new VBox(10);
        contenedorTotal.setAlignment(Pos.CENTER);

        if (estaArriba) {
            contenedorTotal.getChildren().addAll(this.vistaMano, contenedor);
        } else {
            contenedorTotal.getChildren().addAll(contenedor, this.vistaMano);
        }

        this.getChildren().add(contenedorTotal);
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

        VBox contenedorLateral = new VBox(40);
        contenedorLateral.setAlignment(Pos.CENTER);
        contenedorLateral.setPadding(new Insets(10));

        if (estaArriba) {
            contenedorLateral.getChildren().addAll(descarte, mazo);
        } else {
            contenedorLateral.getChildren().addAll(mazo, descarte);
        }
        return contenedorLateral;
    }
}


