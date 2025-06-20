package edu.fiuba.algo3.modelo.cartas;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;

public interface ICarta {
    void jugarCarta(Jugador jugador, Seccion seccion);
}
