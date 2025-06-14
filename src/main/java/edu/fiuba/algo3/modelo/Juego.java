package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.jugador.atril.*;
import edu.fiuba.algo3.modelo.posiciones.Posicion;


import java.util.HashMap;


public class Juego {
    private HashMap<Jugador, Atril> atriles;
    private Jugador jugadorActual;

    public Juego(Jugador jugador1, Jugador jugador2){
        atriles = new HashMap<>();
        atriles.put(jugador1, new Atril());
        atriles.put(jugador2, new Atril());

        this.jugadorActual = jugador1; // de momento es siempre jugador1
    }

    public void repartirCartasALosJugadores(){
        for (Jugador jugador : atriles.keySet()) {
            jugador.robarCartas(10);
        }
    }

    public void jugarCarta(Jugador jugador, ICarta cartaElegida, Posicion posiccionElegida){
        //if(jugador != this.jugadorActual) //lanza exepcion que debe atrapar el controlador
        // if(! posiccionElegida.esCompatible(cartaElegida.getPosiccion)) tambien lanza exepcion

        jugador.removerCartaDeLaMano(cartaElegida); //Supongo que en la app no podes jugar cartas que no estan ya en tu mano

        cartaElegida.jugarEnJuego(jugador, this, posiccionElegida); //le paso el juego y que la carta decida que hacer

    }

    public Atril getAtril(Jugador jugador){
        return atriles.get(jugador);
    }

    public int calcularPuntaje(Jugador jugador){
        return atriles.get(jugador).calcularPuntaje();
    }
}
