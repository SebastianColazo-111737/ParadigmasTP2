package edu.fiuba.algo3.modelo.tablero;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.tablero.atril.Atril;

import java.util.HashMap;

public class Tablero {
    private HashMap<Jugador, Atril> atriles;

    public Tablero(){
        this.atriles = new HashMap<>();
    }

    public void agregarJugador(Jugador jugador, Atril atril){
        this.atriles.put(jugador, atril);
    }

    public Atril getAtril(Jugador jugador){
        return this.atriles.get(jugador);
    }

    public Atril getAtrilOponente(Jugador jugador){
        for (Jugador oponente: atriles.keySet()){
            if(!jugador.equals(oponente)){
                return this.atriles.get(oponente);
            }
        }
        return null; //o lanza exepcion
    }
}
