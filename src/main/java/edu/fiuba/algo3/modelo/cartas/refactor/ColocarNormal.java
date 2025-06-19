package edu.fiuba.algo3.modelo.cartas.refactor;

import edu.fiuba.algo3.modelo.cartas.refactor.Unidad;
import edu.fiuba.algo3.modelo.cartas.unidades.UnidadNoPuedeSerJugadaPorEseJugadorEnEsaSeccion;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

public class ColocarNormal extends EstrategiaColocarUnidad{

    public ColocarNormal(Posicion posicion){
        super(posicion);
    }

    @Override
    void colocarUnidad(Unidad unidad, Jugador jugador, Seccion seccion) {
        if(!jugador.lePertenece(seccion)){
            throw new UnidadNoPuedeSerJugadaPorEseJugadorEnEsaSeccion("");
        }
        seccion.colocarUnidad(unidad);
    }
}
