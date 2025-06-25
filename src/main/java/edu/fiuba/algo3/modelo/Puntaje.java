package edu.fiuba.algo3.modelo;

public class Puntaje {
    private int puntajeBase;
    private int puntajeActual;

    public Puntaje(int puntajeBase){
        this.puntajeBase = puntajeBase;
        this.puntajeActual = puntajeBase;
    }

    public int getPuntajeBase(){
        return this.puntajeBase;
    }

    public int getPuntajeActual(){
        return this.puntajeActual;
    }

    public void setPuntajeActual(int nuevoPuntaje){
        this.puntajeActual = nuevoPuntaje;
    }

    public void multiplicarPuntaje(int multiplicador){
        this.puntajeActual*= multiplicador;
    }
}
