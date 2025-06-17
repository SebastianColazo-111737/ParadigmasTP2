package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

public class AdminTurnos {
    private List<Jugador> jugadores;
    private int indiceActualJugador;
    private List<Boolean> jugadorPasoTurno;

    public AdminTurnos(List<Jugador> jugadores){
        this.jugadores = jugadores;
        this.indiceActualJugador = 0;

        this.jugadorPasoTurno = new ArrayList<>();
        this.jugadorPasoTurno.add(false);
        this.jugadorPasoTurno.add(false);
    }

    public Jugador getJugadorActual(){
        return this.jugadores.get(indiceActualJugador);
    }

    public void setJugadorActual(Jugador jugador){
        this.indiceActualJugador = jugadores.indexOf(jugador);
    }

    public void jugadorPasaTurno(Jugador jugador){
        int indiceJugador = jugadores.indexOf(jugador);
        this.jugadorPasoTurno.set(indiceJugador, true);
    }

    public void proximoTurno() {
        do {
            this.indiceActualJugador = (this.indiceActualJugador + 1) % 2;
        } while (jugadorPasoTurno.get(this.indiceActualJugador) && !ambosPasaronTurno());
    }

    public boolean ambosPasaronTurno() {
        return jugadorPasoTurno.get(0) && jugadorPasoTurno.get(1);
    }

    public void reiniciarRonda(){
        this.jugadorPasoTurno.set(0, false);
        this.jugadorPasoTurno.set(1, false);
        this.indiceActualJugador = 0;

    }

    public boolean esSuTurno(Jugador jugador){
        return this.jugadores.get(indiceActualJugador).equals(jugador);
    }
}
