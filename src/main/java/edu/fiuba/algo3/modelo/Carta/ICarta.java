package edu.fiuba.algo3.modelo.Carta;

import edu.fiuba.algo3.clases.Seccion.Seccion;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Posicion.IPosicion;
import edu.fiuba.algo3.modelo.Tablero.Tablero;

public interface ICarta {
    public void jugarCarta(Jugador jugador, Tablero tablero, IPosicion posicion);
}
