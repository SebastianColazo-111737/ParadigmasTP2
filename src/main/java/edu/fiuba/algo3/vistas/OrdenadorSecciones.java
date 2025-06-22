package edu.fiuba.algo3.vistas;


import edu.fiuba.algo3.modelo.posiciones.Asedio;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posiciones.Distancia;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrdenadorSecciones {

    public static int ordenVisual(Seccion seccion, boolean estaArriba) {
        if (seccion.getPosicion() instanceof Asedio) {
            return estaArriba ? 0 : 2;
        } else if (seccion.getPosicion() instanceof Distancia) {
            return 1;
        } else if (seccion.getPosicion() instanceof CuerpoACuerpo) {
            return estaArriba ? 2 : 0;
        }
        return 3;
    }
    public static List<Seccion> ordenar(List<Seccion> secciones, boolean estaArriba) {
        return secciones.stream()
                .sorted(Comparator.comparingInt(seccion -> ordenVisual(seccion, estaArriba)))
                .collect(Collectors.toList());
    }
}