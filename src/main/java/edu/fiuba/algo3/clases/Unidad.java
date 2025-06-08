package edu.fiuba.algo3.clases;

public class Unidad implements Carta {
  private String nombre;
  private int puntosBase;
  private Posicion posicion;
  private Modificador modificador;
  private int puntosModificados;

  public Unidad(String nombre, int puntosBase, Posicion seccion, Modificador modificador) {
    this.nombre = nombre;
    this.puntosBase = puntosBase;
    this.puntosModificados = puntosBase;
    this.posicion = seccion;
    this.modificador = modificador;

  }

  public Boolean jugar(Tablero tablero, Jugador jugador, Posicion posicion) {
    if (!tablero.colocarUnidad(this, jugador, posicion)) {
      System.out.println("No se pudo colocar la carta");
      return false;
    }

    if (poseeModificadores()) {
      this.modificador.aplicarEfecto(this, tablero, jugador);
      System.out.println("Se aplico modificador");
    }
    return true;
  }

  public int getPuntosModificados() {
    return this.puntosModificados;
  }

  public void sumarPuntosModificados(int puntos) {
    this.puntosModificados += puntos;
  }

  public void modificarPuntos(int nuevoValor){
    this.puntosModificados = nuevoValor;
  }



  public Boolean poseeModificadores() {
    return this.modificador != null;
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
