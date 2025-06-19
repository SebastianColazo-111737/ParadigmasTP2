package edu.fiuba.algo3.modelo.cartas.refactor;


import edu.fiuba.algo3.modelo.cartas.refactor.Unidad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;

import java.util.ArrayList;
import java.util.List;

public abstract class EstrategiaColocarUnidad {
    protected List<Posicion> posicionesDisponibles;

    public EstrategiaColocarUnidad(Posicion posicicon){
        this.posicionesDisponibles = new ArrayList<>();
        this.posicionesDisponibles.add(posicicon);
    }

    public boolean sePuedeColocar(Posicion posicion){
        for(Posicion posicionesDisponibles: posicionesDisponibles){
            if(posicionesDisponibles.esCompatible(posicion)){
                return true;
            }
        }
        return false;
    }

    abstract void colocarUnidad(Unidad unidad, Jugador jugador, Seccion seccion);
}
