package edu.fiuba.algo3.modelo.cartas.unidades;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Puntaje;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

public class Animador extends Unidad {
  public Animador(String nombre, Puntaje puntaje, Posicion posicion) {
    super(nombre, puntaje, posicion);
  }

  @Override
  public void jugar(Jugador jugadorActual, Jugador jugadorSiguiente, Posicion posicion) {

    jugadorActual.colocarUnidad(this, posicion);
  }

  public String nombre() {
    return this.nombre;
  }
}
