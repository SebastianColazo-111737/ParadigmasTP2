package edu.fiuba.algo3.modelo.cartas.unidades;

import edu.fiuba.algo3.modelo.jugador.Puntaje;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;

public class Agil extends Unidad {

  public Agil(String nombre, Puntaje puntaje, Posicion posicion1, Posicion posicion2) {
    super(nombre, puntaje, posicion1);
    this.posicionesDisponibles.add(posicion2);
  }

  @Override
  public void jugar(Jugador jugadorActual, Jugador jugadorSiguiente, Posicion posicion) {

    jugadorActual.colocarUnidad(this, posicion);
  }

  public String nombre() {
    return this.nombre;
  }
}
