package edu.fiuba.algo3.modelo.cartas.Especiales;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.tablero.atril.Atril;

public class MoraleBoost implements ICarta {
    private String nombre;
    private Posicion posicionAfectada;

    public MoraleBoost(String nombre, Posicion posicionAfectada){
        this.nombre = nombre;
        this.posicionAfectada = posicionAfectada;
    }

    @Override
    public void jugarCarta(Jugador jugador, Tablero tablero, Posicion posicion) {
        Atril atrilJugador = tablero.getAtril(jugador);
        atrilJugador.activarMoraleBoost(posicionAfectada);
    }
}
