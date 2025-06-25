package edu.fiuba.algo3.modelo.cartas.unidades;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.tablero.Atril;

public abstract class UnidadDecoradora implements Unidad {
    protected Unidad unidad;

    public UnidadDecoradora(Unidad unidad){
        this.unidad = unidad;
    }

    @Override
    public String getNombre(){
        return unidad.getNombre();
    }

    @Override
    public boolean sePuedeColocar(Posicion posicion){
        return unidad.sePuedeColocar(posicion);
    }

    @Override
    public Atril atrilDestino(Jugador jugador, Tablero tablero) {
        return unidad.atrilDestino(jugador, tablero);
    }

    @Override
    public void realizarAccionAdicional(Jugador jugador, Tablero tablero) {
        unidad.realizarAccionAdicional(jugador, tablero);
    }
}
