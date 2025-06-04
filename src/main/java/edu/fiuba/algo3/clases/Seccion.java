package edu.fiuba.algo3.clases;

import java.util.ArrayList;
import java.util.List;

public class Seccion {
  private List<Unidad> unidadesJugadas;
  private Jugador jugador;

  public Seccion() {
    this.unidadesJugadas = new ArrayList<>();
  }

  public Seccion(Jugador jugador) {
    this.jugador = jugador;
    this.unidadesJugadas = new ArrayList<>();
  }

  public Jugador getJugador() {
    return this.jugador;
  }

  public Boolean colocarUnidad(Unidad unidad) {
    this.unidadesJugadas.add(unidad);
    return true;
  }

  public int getCantUnidades() {
    return unidadesJugadas.size();
  }

  public boolean perteneceAJugador(Jugador jugador) {
    return this.jugador == jugador;
  }

  public int obtenerPuntaje() {
    int total = 0;
    for (Unidad unidad : unidadesJugadas) {
      total += unidad.getValorAtaque();
    }
    return total;
  }

}
