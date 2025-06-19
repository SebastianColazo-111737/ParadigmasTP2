package edu.fiuba.algo3.aux.cartas;


import edu.fiuba.algo3.aux.Juego.Juego;
import edu.fiuba.algo3.aux.jugador.Jugador;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

public interface ICarta {
    void jugarEnJuego(Jugador jugador, Juego juego, Posicion posicionElegida);

}
