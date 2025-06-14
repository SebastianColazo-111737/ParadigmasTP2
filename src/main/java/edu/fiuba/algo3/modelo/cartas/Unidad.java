package edu.fiuba.algo3.modelo.cartas;

import edu.fiuba.algo3.modelo.posiciones.Posicion;

public class Unidad implements ICarta {
    private String nombre;
    private int puntosBase; //puede ser una clase
    private Posicion posicion;

    public Unidad(String nombre, int puntosBase, Posicion posicicon){
        this.nombre = nombre;
        this.puntosBase = puntosBase;
        this.posicion = posicicon;
    }

    public Boolean puedeColocarse(Posicion posiccion){
        return posiccion.esCompatible(posiccion);
    }
}
