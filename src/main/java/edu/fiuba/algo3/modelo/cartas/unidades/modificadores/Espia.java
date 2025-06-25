package edu.fiuba.algo3.modelo.cartas.unidades.modificadores;

import edu.fiuba.algo3.modelo.cartas.unidades.Unidad;
import edu.fiuba.algo3.modelo.cartas.unidades.UnidadDecoradora;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.tablero.Atril;

public class Espia extends UnidadDecoradora {
    private final static int CantidadDeCartasParaRobar = 2;

    public Espia(Unidad unidad) {
        super(unidad);
    }

    @Override
    public Atril atrilDestino(Jugador jugador, Tablero tablero){
        return tablero.getAtrilOponente(jugador);
    }

    @Override
    public void realizarAccionAdicional(Jugador jugador, Tablero tablero){
        jugador.robarCartasDelMazo(CantidadDeCartasParaRobar);
        super.unidad.realizarAccionAdicional(jugador, tablero);
    }

}
