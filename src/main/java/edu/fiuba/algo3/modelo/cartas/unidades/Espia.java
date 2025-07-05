package edu.fiuba.algo3.modelo.cartas.unidades;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Puntaje;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

public class Espia extends Unidad {

  public Espia(String nombre, Puntaje puntaje, Posicion posicion) {
    super(nombre, puntaje, posicion);
  }

  @Override
  public void jugar(Jugador jugadorActual, Jugador JugadorSiguiente, Posicion posicion) {
    JugadorSiguiente.colocarUnidad(this, posicion);
    jugadorActual.robarCartasDelMazo(2);
  }

  public String nombre() {
    return this.nombre;
  }

  public String colorHex() {
    return "#A9A9A9";
  }
}
