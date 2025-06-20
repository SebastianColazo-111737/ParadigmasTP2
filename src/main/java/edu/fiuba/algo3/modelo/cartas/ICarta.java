package edu.fiuba.algo3.modelo.cartas;


import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

public interface ICarta {
    void jugarEnJuego(Jugador jugador, Juego juego, Posicion posicionElegida);
    // las cartas se saben jugar por eso reciben el juego
}
