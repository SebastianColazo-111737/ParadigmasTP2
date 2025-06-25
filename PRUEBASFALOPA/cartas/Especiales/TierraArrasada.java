package edu.fiuba.algo3.modelo.cartas.Especiales;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import edu.fiuba.algo3.modelo.tablero.Tablero;

public class TierraArrasada implements ICarta {


    @Override
    public void jugarCarta(Jugador jugador, Tablero tablero, Posicion posicion) {
        // busco en los 2 atriles las cartas con mas puntaje,
        // me quedo con el mayor puntaje y elimino en los 2 atriles las cartas
        // que tengan ese puntaje
    }
}
