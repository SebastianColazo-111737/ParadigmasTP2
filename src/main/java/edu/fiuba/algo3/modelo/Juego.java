package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    private List<Jugador> jugadores;


    public Juego(Jugador jugador1, Jugador jugador2){
        jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

    }

    public void repartirCartasALosJugadores(){
        for (Jugador jugador : jugadores) {
            jugador.robarCartas(10);
        }
    }
}
