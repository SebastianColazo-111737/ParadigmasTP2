package edu.fiuba.algo3.modelo.gwent.adminRondas.reglaDeCierre;

import edu.fiuba.algo3.modelo.gwent.adminRondas.Ronda;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.Hashtable;
import java.util.List;

public class MejorDe3 implements ReglaDeCierre {
    private Jugador ganador;

    public MejorDe3(){
        this.ganador = null;
    }

    @Override
    public boolean terminoElJuego(List<Ronda> rondas) {
        Hashtable<Jugador, Integer> rondasGanadas = new Hashtable<>();

        for (Ronda ronda: rondas) {
            Jugador ganadorRonda = ronda.getGanador();
            rondasGanadas.put(
                    ganadorRonda,
                    rondasGanadas.getOrDefault(ganadorRonda, 0) + 1
            );
            if (rondasGanadas.get(ganadorRonda) == 2) {
                this.ganador = ganadorRonda;
                return true;
            }
        }
        return false;
    }

    @Override
    public Jugador getGanador() {
        return this.ganador;
    }
}
