package edu.fiuba.algo3.modelo.cartas.unidades;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Puntaje;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

public class Legendaria extends Unidad {

  public Legendaria(String nombre, Puntaje puntaje, Posicion posicion) {
    super(nombre, puntaje, posicion);
  }

  @Override
  public void jugar(Jugador jugadorActual, Jugador jugadorSiguiente, Posicion posicion) {
    jugadorActual.colocarUnidad(this, posicion);
  }

  public String nombre() {
    return this.nombre;
  }

  public String colorHex() {
    return "#FFD700";
  }
}
