package edu.fiuba.algo3.clases;

public class Unidad implements Carta {
    private String nombre;
    private int puntosBase;

    public Unidad(String nombre, int puntosBase) {
        this.nombre = nombre;
        this.puntosBase = puntosBase;
    }

    public int getValorAtaque() {
        return this.puntosBase;
    }

    public int obtenerPuntosBase(){
        return this.puntosBase;
    }

    public String getName() {
        return this.nombre;
    }

}