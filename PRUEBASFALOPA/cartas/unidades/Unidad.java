package edu.fiuba.algo3.modelo.cartas.unidades;



import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.juego.Puntaje;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

import java.util.ArrayList;
import java.util.List;

public abstract class Unidad implements ICarta {

    protected String nombre;
    protected Puntaje puntaje;
    protected List<Posicion> posicionesDisponibles;

    public Unidad(String nombre, Puntaje puntaje, Posicion posicicon){
        this.nombre = nombre;
        this.puntaje = puntaje;

        this.posicionesDisponibles = new ArrayList<>();
        this.posicionesDisponibles.add(posicicon);
    }

    public String getNombre(){return this.nombre;}

    public Puntaje getPuntaje(){return this.puntaje;}

    public boolean sePuedeColocar(Posicion posicion){
        for(Posicion posicionesDisponibles: posicionesDisponibles){
            if(posicionesDisponibles.esCompatible(posicion)){
                return true;
            }
        }
        return false;
    }

    public abstract void calcularPuntajeActual(List<Unidad> unidades);

    public int getPuntajeActual(){
        return this.puntaje.getPuntajeActual();
    }

}
