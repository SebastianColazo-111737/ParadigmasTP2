package edu.fiuba.algo3.modelo.carta;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posicion.Posicion;

public interface Carta {
    void jugarCarta(Jugador jugador, Jugador oponente, Posicion posicionElegida);
    String getNombre();
}
