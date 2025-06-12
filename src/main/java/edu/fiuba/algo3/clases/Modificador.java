package edu.fiuba.algo3.clases;

public interface Modificador {
  //protected boolean esLegendaria;

  //public Boolean esLegendaria() {
  //  return this.esLegendaria;
  //}

  // Tal vez deba cambiar el nombre, por los parametros, no todas usaran posicion
  public void aplicarEfectoNato(Unidad unidad, Posicion nuevaPosicion);
  public void aplicarEfectoEnTablero(Carta cartaContexto, Tablero tablero, Jugador jugador);
}
