package edu.fiuba.algo3.modelo.carta.unidad.modificadores;


import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.modelo.posicion.Posicion;

public class Agil extends UnidadModificada {
    private Posicion posicionExtra;

    public Agil(Unidad unidad, Posicion posicionExtra) {
        super(unidad);
        this.posicionExtra = posicionExtra;
    }

    @Override
    public boolean sePuedeColocar(Posicion posicion){
        return super.unidad.sePuedeColocar(posicion) || posicionExtra.esCompatible(posicion);
    }
}
