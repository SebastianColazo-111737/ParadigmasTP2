package edu.fiuba.algo3.pruebaDeConcepto;

public class Unidad implements Carta{
    private int puntaje;
    private Posicion posicion;

    public Unidad(int puntaje, Posicion posicion){
        this.puntaje = puntaje;
        this.posicion = posicion;
    }
    @Override
    public void jugarCarta(Tablero tablero, Jugador jugador) {
        tablero.colocarUnidad(this, jugador);
    }

    @Override
    public String toString() {
        return "Unidad{" + "puntaje: " + puntaje + ", posicion: " + posicion + '}';
    }

    public Posicion getPosicion(){
        return this.posicion;
    }

    public int getPuntaje(){
        return this.puntaje;
    }
}
