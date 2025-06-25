package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.juego.Gwent;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class ControladorTurnos {
    private final Gwent juego;

    public ControladorTurnos(Gwent juego){
        this.juego = juego;
    }

    public Jugador jugadorActual(){
      return juego.getJugadorActual();
    }

    public void AvanzarTurno(){
        juego.pasarTurno();
        System.out.println("Nuevo turno: " + juego.getJugadorActual());
    }
}
