package edu.fiuba.algo3.modelo.Tablero;


import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Posicion.IPosicion;
import edu.fiuba.algo3.modelo.Carta.*;

import java.util.HashMap;
import java.util.Map;

public class Tablero {

    private Map<Jugador, Mesa> mesas;

    public Tablero(Jugador jugador1, Jugador jugador2) {
        this.mesas = new HashMap<>();
        this.mesas.put(jugador1, new Mesa());
        this.mesas.put(jugador2, new Mesa());
    }


    public void colocarUnidad(Unidad unidad, Jugador jugador, IPosicion posicion){
        mesas.get(jugador).colocarUnidad(unidad, posicion);
    }
}
