package edu.fiuba.algo3.aux.cartas.unidades;

import edu.fiuba.algo3.aux.cartas.ICarta;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

import java.util.ArrayList;
import java.util.List;

public abstract class Unidad implements ICarta {
    private String nombre;
    protected int puntosBase; //puede ser una clase
    protected List<Posicion> posicionesDisponibles;

    public Unidad(String nombre, int puntosBase, Posicion posicicon){
        this.nombre = nombre;
        this.puntosBase = puntosBase;

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

    public String getNombre(){return this.nombre;}

    abstract  public int calcularPuntaje();
}
