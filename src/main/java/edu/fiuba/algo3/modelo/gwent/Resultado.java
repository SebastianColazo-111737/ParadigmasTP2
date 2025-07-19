package edu.fiuba.algo3.modelo.gwent;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import java.util.HashMap;
import java.util.List;

public class Resultado {

    private HashMap<Jugador, Integer> puntuacion;
    private Jugador ganador;

    public Resultado(List<Jugador> jugadores){
        this.puntuacion = new HashMap<>();
        this.ganador = null;

        int maxPuntaje = Integer.MIN_VALUE;
        for (Jugador jugador : jugadores) {
            int puntaje = jugador.getPuntaje();
            puntuacion.put(jugador, puntaje);

            if (puntaje > maxPuntaje) {
                maxPuntaje = puntaje;
                ganador = jugador;
            }
        }
    }

    public Jugador getGanador(){return this.ganador;}
    public HashMap<Jugador, Integer> getPuntuacion(){return this.puntuacion;}
}
