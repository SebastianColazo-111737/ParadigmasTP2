package edu.fiuba.algo3.modelo.carta.unidad.modificadores;


import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.modelo.posicion.Posicion;

import java.util.List;

public class Agil extends UnidadModificada {
    private List<Posicion> posicionesExtra;

    public Agil(Unidad unidad, List<Posicion> posicionesExtra) {
        super(unidad);
        this.posicionesExtra = posicionesExtra;
    }

    @Override
    public boolean sePuedeColocar(Posicion posicion){
        boolean sePuedeColocarEnLasPosicionesExtra = false;
        for(Posicion pos: posicionesExtra){
            sePuedeColocarEnLasPosicionesExtra =
                    sePuedeColocarEnLasPosicionesExtra || pos.esCompatible(posicion);
        }
        return super.unidad.sePuedeColocar(posicion) || sePuedeColocarEnLasPosicionesExtra;
    }
}
