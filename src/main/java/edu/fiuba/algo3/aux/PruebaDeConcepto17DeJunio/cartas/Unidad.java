package edu.fiuba.algo3.aux.PruebaDeConcepto17DeJunio.cartas;

import edu.fiuba.algo3.aux.PruebaDeConcepto17DeJunio.posiciones.Posicion;

import java.util.ArrayList;
import java.util.List;

public abstract class Unidad implements ICarta {
    private String nombre;
    protected int puntosBase;
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

    abstract  public int calcularPuntaje();
}
