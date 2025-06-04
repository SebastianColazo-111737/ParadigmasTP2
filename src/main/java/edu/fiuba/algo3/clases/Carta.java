package edu.fiuba.algo3.clases;

public interface Carta {
  String getName();

  int getValorAtaque();

  void jugarCarta(Tablero tablero, Jugador jugador);

  Posicion getPosicion();
}
