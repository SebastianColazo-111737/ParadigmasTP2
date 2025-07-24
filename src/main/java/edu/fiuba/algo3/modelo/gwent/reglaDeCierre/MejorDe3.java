package edu.fiuba.algo3.modelo.gwent.reglaDeCierre;

import edu.fiuba.algo3.modelo.gwent.Resultado;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.HashMap;
import java.util.List;

public class MejorDe3 implements ReglaDeCierre {
    private Jugador ganador;

    public MejorDe3(){
        this.ganador = null;
    }
    @Override
    public boolean terminoElJuego(List<Resultado> resultados) {
        HashMap<Jugador, Integer> rondasGanadas = new HashMap<>();

        for (Resultado resultado: resultados) {
            Jugador ganadorRonda = resultado.getGanador();
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
        if(this.ganador == null){
            throw new NoSePudoDefinirUnGanadorError("Con los ultimos resultados no se definio un ganador");
        }
        return this.ganador;
    }
}
