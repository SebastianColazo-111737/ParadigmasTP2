package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.juego.Gwent;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class RegistrarJugadores {
    private Jugador jugador1;
    private Jugador jugador2;
    private int turno = 1;

    public void registarAlJugador(Jugador jugador){
        if(turno == 1){
            this.jugador1 = jugador;
            turno++;
        }else{
            this.jugador2 = jugador;
        }
    }

    public boolean estaCompleto(){
        return jugador1!= null && jugador2 != null;
    }

    public Gwent constriuirElJuego(){
        return new Gwent(jugador1,jugador2);
    }
}
