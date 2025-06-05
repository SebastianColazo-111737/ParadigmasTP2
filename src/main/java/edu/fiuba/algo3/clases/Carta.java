package edu.fiuba.algo3.clases;

public interface Carta {
  String getName();

  Boolean jugar(Tablero tablero, Jugador jugador, Posicion posicion);

  Posicion getPosicion();
}
