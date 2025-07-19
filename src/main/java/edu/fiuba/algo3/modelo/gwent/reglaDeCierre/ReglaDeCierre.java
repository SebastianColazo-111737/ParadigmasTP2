package edu.fiuba.algo3.modelo.gwent.reglaDeCierre;


import edu.fiuba.algo3.modelo.gwent.Resultado;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.List;

public interface ReglaDeCierre {
    boolean terminoElJuego(List<Resultado> resultados);
    Jugador getGanador();
}
