package edu.fiuba.algo3.clases;

public abstract class Modificador {
  protected boolean esLegendaria;

  public Boolean esLegendaria() {
    return this.esLegendaria;
  }

  public abstract void aplicarEfecto(Carta cartaEnDescarte, Tablero tablero, Jugador jugador);
}
