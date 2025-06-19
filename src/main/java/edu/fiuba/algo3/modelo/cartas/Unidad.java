package edu.fiuba.algo3.modelo.cartas;

import edu.fiuba.algo3.modelo.jugador.Seccion;
import edu.fiuba.algo3.modelo.modificadores.Modificador;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

import java.util.ArrayList;
import java.util.List;

public class Unidad extends Carta {
    private String nombre;
    private List<Modificador> modificadores;
    private Boolean invasiva;

    private int puntosBase;
    private int puntosEspeciales;
    private List<Posicion> posiciones;

    public Unidad(String nombre, int puntosBase, List<Posicion> posiciones, Boolean esInvasiva){
        this.nombre = nombre;
        this.puntosBase = puntosBase;
        this.puntosEspeciales = 0;    // Se usan en clima activado
        this.posiciones = posiciones;
        this.invasiva = esInvasiva;
        this.modificadores = new ArrayList<>();
    }

    public void setModificadores(List<Modificador> modificadores){
        this.modificadores = modificadores;
    }

    public String getNombre(){
        return nombre;
    }

    public int getPuntosBase(){
        return puntosBase;
    }

    public void setPuntosBase(int nuevosPuntos){
        this.puntosBase = nuevosPuntos;
    }

    public int getPuntosEspeciales(){
        return puntosEspeciales;
    }

    public void setPuntosEspeciales(int nuevosPuntos){
        this.puntosEspeciales = nuevosPuntos;
    }

    public Boolean compararPoder(Unidad otraUnidad){
        return this.getPuntosBase() > otraUnidad.getPuntosBase();
    }

    @Override
    public void jugarEnSeccion(Seccion seccion){
        seccion.agregarUnidad(this);
        //seccion.aplicarHechizo(); ¿hago que seccion active a todas las unidades a la vez? seccion.aplicarHechizoS() desde Juego.
    }

    @Override
    public void activar(Seccion seccion){
        for(Modificador modificador: modificadores){
            modificador.aplicarEfecto(seccion);
        }
    }

    public Boolean compararPosicion(Posicion otraPosicion){
        Boolean esCompatible = false;
        for(Posicion posicion : posiciones){
            esCompatible = posicion.esCompatible(otraPosicion);
        }
        return esCompatible;
    }

    public Boolean sosInvasiva(){return this.invasiva;}
}
