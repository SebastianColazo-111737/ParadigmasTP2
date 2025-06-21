package edu.fiuba.algo3.vistas.Contenedores;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.modelo.jugador.atril.Atril;
import edu.fiuba.algo3.modelo.posiciones.Asedio;
import edu.fiuba.algo3.modelo.posiciones.Distancia;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class VistaAtril extends VBox {

    public VistaAtril(Atril atril, boolean estaArriba) {
        this.setSpacing(5);
        this.setAlignment(Pos.CENTER);

        List<Seccion> secciones = atril.getSecciones();

        List<Seccion> ordenadas = ordenarSeccionesVisualmente(secciones, estaArriba);

        for (Seccion seccion : ordenadas) {
            VistaSeccion vistaSeccion = new VistaSeccion(seccion);
            this.getChildren().add(vistaSeccion);
        }
    }

    private List<Seccion> ordenarSeccionesVisualmente(List<Seccion> secciones, boolean estaArriba) {
        Comparator<Seccion> comparator = Comparator.comparing(seccion -> {
            String nombre = seccion.getClass().getSimpleName();
            if (seccion.compararPosiciones(new Asedio())) return "1";
            if (seccion.compararPosiciones(new Distancia())) return "2";
            return "3";
        });
        if (!estaArriba) {
            comparator = comparator.reversed();
        }
        return secciones.stream().sorted(comparator).collect(Collectors.toList());
    }
}