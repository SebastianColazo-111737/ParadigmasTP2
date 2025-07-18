package edu.fiuba.algo3.modelo.cartas.unidades;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Puntaje;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

public class Unidas extends Unidad {

  public Unidas(String nombre, Puntaje puntaje, Posicion posicion) {
    super(nombre, puntaje, posicion);
  }

  @Override
  public void jugar(Jugador jugadorActual, Jugador jugadorSiguiente, Posicion posicion) {
    jugadorActual.colocarUnidad(this, posicion);
  }

  public String nombre() {
    return this.nombre;
  }

  @Override
  public int getPuntajeTotal(Seccion seccion) {
    long cantidadDeEstas = seccion.getUnidadesColocadas().stream()
        .filter(unidad -> unidad.getClass().equals(this.getClass())
            && unidad.nombre().equals(this.nombre()))
        .count();
    return this.puntaje.getPuntajeActual() * (int) Math.pow(2, cantidadDeEstas - 1);
  }

  public String colorHex() {
    return "#2E8B57";
  }
}
