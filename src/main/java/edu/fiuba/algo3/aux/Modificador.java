package edu.fiuba.algo3.aux;

public abstract class Modificador {
  protected boolean esLegendaria;

  public Boolean esLegendaria() {
    return this.esLegendaria;
  }

  public abstract void aplicarEfecto(Carta cartaContexto, Tablero tablero, Jugador jugador);
}
