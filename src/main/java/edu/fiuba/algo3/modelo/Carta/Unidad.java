package edu.fiuba.algo3.modelo.Carta;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Tablero.Tablero;
import edu.fiuba.algo3.modelo.Posicion.IPosicion;

public class Unidad implements ICarta {
    private IPosicion posicion;
    private int puntaje;

    public Unidad(IPosicion posicion, int puntajeInicial){
        this.posicion = posicion;
        this.puntaje = puntajeInicial;
    }

    @Override
    public void jugarCarta(Jugador jugador, Tablero tablero, IPosicion posicion){
        tablero
    }

    public boolean sePuedeColocarEnLaPosicion(IPosicion posicion){
        return posicion.esCompatible(posicion);
    }

    public int calcularPuntaje(){
        return this.puntaje;
    }
}
