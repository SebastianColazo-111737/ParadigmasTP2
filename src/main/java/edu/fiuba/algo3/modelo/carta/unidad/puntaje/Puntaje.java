package edu.fiuba.algo3.modelo.carta.unidad.puntaje;

public class Puntaje {
    private int puntajeBase;
    private int puntajeActual;

    public Puntaje(int puntajeBase){
        this.puntajeBase = puntajeBase;
        this.puntajeActual = puntajeBase;
    }

    public void aplicarEfecto(Efecto efecto){
        int nuevoPuntaje = efecto.aplicar(this.puntajeActual);
        this.puntajeActual = nuevoPuntaje;
    }

    public void resetearPuntaje(){
        this.puntajeActual = this.puntajeBase;
    }

    public int getPuntajeActual(){
        return this.puntajeActual;
    }

}
