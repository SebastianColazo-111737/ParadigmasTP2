package edu.fiuba.algo3.modelo.cartas.unidades;

import edu.fiuba.algo3.modelo.cartas.Carta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.tablero.Atril;


public interface Unidad extends Carta {

    @Override
    default void jugarCarta(Jugador jugador, Tablero tablero, Posicion posicion){
        if(!sePuedeColocar(posicion)){
            throw new UnidadNoPuedeSerJugadaEnEsaPosicion("");
        }
        Atril atril = atrilDestino(jugador, tablero);
        atril.colocarUnidad(this, posicion);

        realizarAccionAdicional(jugador, tablero);
    }

    boolean sePuedeColocar(Posicion posicion);
    Atril atrilDestino(Jugador jugador, Tablero tablero);
    void realizarAccionAdicional(Jugador jugador, Tablero tablero);

    String getNombre();
}
