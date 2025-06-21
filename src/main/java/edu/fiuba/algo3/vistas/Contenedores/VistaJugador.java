package edu.fiuba.algo3.vistas.Contenedores;

import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.modelo.posiciones.Asedio;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posiciones.Distancia;
import edu.fiuba.algo3.vistas.Individuales.VistaDescarte;
import edu.fiuba.algo3.vistas.Individuales.VistaMazo;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import java.util.List;
import java.util.stream.Collectors;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class VistaJugador extends VBox {
    public VistaJugador(Jugador jugador, boolean estaArriba){
        super(10);
        this.setAlignment(Pos.CENTER); //Si se ve raro el vistaJugador sacar estooo!!

        VistaAtril vistaAtril = new VistaAtril(jugador.atril(), estaArriba);

        VBox secciones = new VBox(5);

        List<Seccion> seccionesOrdenadas = jugador.atril().getSecciones()
                .stream()
                .sorted((s1, s2) -> {
                    int orden1 = ordenSeccion(s1, estaArriba);
                    int orden2 = ordenSeccion(s2, estaArriba);
                    return Integer.compare(orden1, orden2);
                })
                .collect(Collectors.toList());

        for (Seccion seccion : seccionesOrdenadas) {
            secciones.getChildren().add(new VistaSeccion(seccion));
        }
        secciones.setAlignment(Pos.CENTER);

        VistaDescarte descarte = new VistaDescarte("Pila Descarte");
        VistaMazo mazo = new VistaMazo("Mazo");

        VistaMano vistaMano = new VistaMano(jugador.mano().getCartas(),carta -> {
            System.out.println("Se selecciono: " + carta.nombre());
        });

        HBox contenedorLateral = new HBox(40,descarte,mazo);
        contenedorLateral.setAlignment(Pos.CENTER_RIGHT);

        VBox contenedorManoyMazo = estaArriba
                ? new VBox(10, contenedorLateral, vistaMano)
                : new VBox(10, vistaMano, contenedorLateral);

        BorderPane contenedor = new BorderPane();
        contenedor.setCenter(secciones);

        if (estaArriba) {
            contenedor.setTop(contenedorManoyMazo);
            BorderPane.setAlignment(contenedorManoyMazo, Pos.TOP_RIGHT);
        } else {
            contenedor.setBottom(contenedorManoyMazo);
            BorderPane.setAlignment(contenedorManoyMazo, Pos.BOTTOM_RIGHT);
        }

        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll( contenedor);
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


