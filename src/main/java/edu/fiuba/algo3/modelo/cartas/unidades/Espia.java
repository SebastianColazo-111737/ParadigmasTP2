package edu.fiuba.algo3.modelo.cartas.unidades;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.juego.Puntaje;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.tablero.atril.Atril;
import edu.fiuba.algo3.modelo.tablero.atril.Seccion;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

import java.util.List;

public class Espia extends Unidad{

    public Espia(String nombre, Puntaje puntaje, Posicion posicion){
        super(nombre,puntaje,posicion);
    }

    @Override
    public void calcularPuntajeActual(List<Unidad> unidades) {

    }

    @Override
    public void jugarCarta(Jugador jugador, Tablero tablero, Posicion posicion){
        if(!this.sePuedeColocar(posicion)){
            throw new RuntimeException();
        }
        Atril atrilOponente = tablero.getAtrilOponente(jugador);
        jugador.robarCartasDelMazo(2);

        atrilOponente.colocarUnidad(this, posicion);
    }
}
