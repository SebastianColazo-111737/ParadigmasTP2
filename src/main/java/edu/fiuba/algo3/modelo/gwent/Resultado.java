package edu.fiuba.algo3.modelo.gwent;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import java.util.HashMap;

public class Resultado {

    private HashMap<Jugador, Integer> puntuacion;
    private Jugador ganador;
    private Boolean empato;

    public Resultado(Jugador jugador1, Jugador jugador2){
        this.puntuacion = new HashMap<>();
        int puntajeJ1 = jugador1.getPuntaje();
        int puntajeJ2 = jugador2.getPuntaje();
        puntuacion.put(jugador1, puntajeJ1);
        puntuacion.put(jugador2, puntajeJ2);

        this.empato = false;
        if(puntajeJ1 > puntajeJ2){
            this.ganador = jugador1;
        }else if(puntajeJ2 > puntajeJ1){
            this.ganador = jugador2;
        }else{
            this.ganador = null;
            this.empato = true;
        }
    }

    public Boolean empato(){return this.empato;}
    public Jugador getGanador(){return this.ganador;}
    public HashMap<Jugador, Integer> getPuntuacion(){return this.puntuacion;}
}
