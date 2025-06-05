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

  public Boolean jugar(Tablero tablero, Jugador jugador, Posicion posicion) {
    return tablero.colocarUnidad(this, jugador, posicion);
  }

  public int obtenerPuntosBase() {
    return this.puntosBase;
  }

  public Posicion getPosicion() {
    return this.posicion;
  }

  public String getName() {
    return this.nombre;
  }

}
