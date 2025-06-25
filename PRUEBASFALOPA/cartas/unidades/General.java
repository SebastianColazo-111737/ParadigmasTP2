package edu.fiuba.algo3.modelo.cartas.unidades;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.juego.Puntaje;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.tablero.atril.Atril;
import edu.fiuba.algo3.modelo.tablero.atril.Seccion;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

import java.util.List;

public class General extends Unidad{
    public General(String nombre, Puntaje puntaje, Posicion posicion){
        super(nombre,puntaje,posicion);
    }

    @Override
    public void calcularPuntajeActual(List<Unidad> unidades) {
        for(Unidad unidad: unidades){
            int puntajeActualUnidad = unidad.puntaje.getPuntajeActual();
            unidad.puntaje.setPuntajeActual(puntajeActualUnidad+1);
        }
    }

    @Override
    public void jugarCarta(Jugador jugador, Tablero tablero, Posicion posicion){
        if(!this.sePuedeColocar(posicion)){
            throw new RuntimeException();
        }
        Atril atrilJugador = tablero.getAtril(jugador);
        atrilJugador.colocarUnidad(this, posicion);
    }
}
