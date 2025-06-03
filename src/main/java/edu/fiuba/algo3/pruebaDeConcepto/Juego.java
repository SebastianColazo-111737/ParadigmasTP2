package edu.fiuba.algo3.pruebaDeConcepto;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    private List<Jugador> jugadores = new ArrayList<>();
    private Tablero tablero;

    public Juego(Jugador jugador1, Jugador jugador2){
        this.jugadores.add(jugador1);
        this.jugadores.add(jugador2);
        this.tablero = new Tablero(jugador1, jugador2);
    }

    public void repartirCartas(){
        for (Jugador jugador: jugadores){
            jugador.robarCartas(10);
        }
    }

    public void jugarCarta(Jugador jugador, Carta carta){
        jugador.jugarCarta(carta, this.tablero);
    }

    public int calcularPuntaje(Jugador jugador){
        return tablero.calcularPuntaje(jugador);
    }

}
