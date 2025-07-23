package edu.fiuba.algo3.vista.vistas;


import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Atril.Seccion;
import edu.fiuba.algo3.modelo.posicion.Asedio;
import edu.fiuba.algo3.modelo.posicion.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posicion.Distancia;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VistaAtril extends VBox {

    public VistaAtril(Atril atril, boolean esJugadorUno) {
        this.setSpacing(10);
        this.setPadding(new Insets(10));
        this.setStyle("-fx-background-color: transparent;");

        List<Seccion> seccionesOrdenadas = atril.getSecciones().stream()
                .sorted(Comparator.comparingInt(seccion -> prioridad(seccion.getPosicion(), esJugadorUno)))
                .collect(Collectors.toList());

        for (Seccion seccion : seccionesOrdenadas) {
            this.getChildren().add(new VistaSeccion(seccion));
        }
    }

    private int prioridad(Posicion posicion, boolean esJugadorUno) {
        if (esJugadorUno) {
            if (posicion instanceof CuerpoACuerpo) return 0;
            if (posicion instanceof Distancia) return 1;
            if (posicion instanceof Asedio) return 2;
        } else {
            if (posicion instanceof Asedio) return 0;
            if (posicion instanceof Distancia) return 1;
            if (posicion instanceof CuerpoACuerpo) return 2;
        }
        return 99;
    }
}
