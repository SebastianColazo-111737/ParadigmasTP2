package edu.fiuba.algo3.modelo.gwent.adminRondas.reglaDeCierre;

import edu.fiuba.algo3.modelo.gwent.adminRondas.Ronda;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.List;

public interface ReglaDeCierre {
    boolean terminoElJuego(List<Ronda> rondas);
    Jugador getGanador();
}
