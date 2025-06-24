package edu.fiuba.algo3.modelo.cartas;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import edu.fiuba.algo3.modelo.tablero.Tablero;

public interface ICarta {
    void jugarCarta(Jugador jugador, Tablero tablero, Posicion posicion);
}
