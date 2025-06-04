package edu.fiuba.algo3.clases;

public class Unidad implements Carta {
  private String nombre;
  private int puntosBase;
  private Posicion posicion;

  public Unidad(String nombre, int puntosBase, Posicion seccion) {
    this.nombre = nombre;
    this.puntosBase = puntosBase;
    this.posicion = seccion;
  }

  public int getValorAtaque() {
    return this.puntosBase;
  }

  public int obtenerPuntosBase() {
    return this.puntosBase;
  }

  public Posicion getPosicion() {
    return this.posicion;
  }

  public void jugarCarta(Tablero tablero, Jugador jugador) {
    tablero.colocarUnidad(this, jugador);
  }

  public String getName() {
    return this.nombre;
  }

}
