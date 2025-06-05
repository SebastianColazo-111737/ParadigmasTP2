package edu.fiuba.algo3.clases;

import java.util.ArrayList;
import java.util.List;

public class Seccion {
  private List<Unidad> unidadesJugadas;
  private Jugador jugador;
  private Posicion tipo;

  public Seccion(Posicion posicion) {
    this.unidadesJugadas = new ArrayList<>();
    this.tipo = posicion;
  }

  public Jugador getJugador() {
    return this.jugador;
  }

  public Boolean colocarUnidad(Unidad unidad) {
    if (unidad.getPosicion() != this.tipo) {
      return false;
    }
    this.unidadesJugadas.add(unidad);
    return true;
  }

  public int getCantUnidades() {
    return unidadesJugadas.size();
  }

  public int obtenerPuntaje() {
    int total = 0;
    for (Unidad unidad : unidadesJugadas) {
      total += unidad.getValorAtaque();
    }
    return total;
  }

}
