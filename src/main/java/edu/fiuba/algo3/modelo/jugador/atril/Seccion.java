package edu.fiuba.algo3.modelo.jugador.atril;

import edu.fiuba.algo3.modelo.cartas.unidades.Animador;
import edu.fiuba.algo3.modelo.cartas.unidades.Unidad;
import edu.fiuba.algo3.modelo.jugador.Puntaje;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

import java.util.ArrayList;
import java.util.List;

public class Seccion {
  private Posicion posicion;
  private List<Unidad> unidadesColocadas;
  private Boolean debuff;
  private int duplicadores;

  public Seccion(Posicion posiccion) {
    this.posicion = posiccion;
    this.unidadesColocadas = new ArrayList<>();
    this.duplicadores = 1;
    this.debuff = false;
  }

  public void agregarDuplicador() {
    this.duplicadores *= 2;
  }

  public Boolean compararPosiciones(Posicion posicion) {
    return this.posicion.esCompatible(posicion);
  }

  public void colocarUnidad(Unidad unidad) {
    if (!unidad.sePuedeColocar(posicion)) {
      throw new SeccionNoPermiteColocarUnidadesConPosicionIncompatible("");
    }
    unidadesColocadas.add(unidad);
  }

  public Unidad tomarCartaMasFuerte() {
    if (this.unidadesColocadas.size() == 0) {
      return null;
    }
    Unidad fuerte = this.unidadesColocadas.get(0);
    for (Unidad unidad : this.unidadesColocadas) {
      if (unidad.masFuerteQue(fuerte)) {
        fuerte = unidad;
      }
    }
    return fuerte;
  }

  public void removerCarta(Unidad carta) {
    // Mejor una excepcion -> Luego
    if (!this.contieneCarta(carta))
      return;
    this.unidadesColocadas.remove(carta);
  }

  public Puntaje calcularPuntajeActualUnidades() {
    if (this.debuff)
      return new Puntaje(this.unidadesColocadas.size());

    int cantAnimadoresEnSeccion = (int) unidadesColocadas.stream()
        .filter(u -> u instanceof Animador)
        .count();

    int puntajeTotal = 0;
    for (Unidad unidad : unidadesColocadas) {
      if (unidad instanceof Animador)
        puntajeTotal += unidad.getPuntajeTotal(this) * this.duplicadores;
      else
        puntajeTotal += unidad.getPuntajeTotal(this) * this.duplicadores + cantAnimadoresEnSeccion;
    }
    return new Puntaje(puntajeTotal);
  }

  public Boolean contieneCarta(Unidad unidad) {
    return this.unidadesColocadas.contains(unidad);
  }

  public List<Unidad> getUnidadesColocadas() {
    return this.unidadesColocadas;
  }

  public List<Unidad> removerCartasJugadas() {
    List<Unidad> descartadas = new ArrayList<>();
    while (!unidadesColocadas.isEmpty()) {
      descartadas.add(unidadesColocadas.remove(0));
    }
    this.debuff = false;
    this.duplicadores = 1;
    return descartadas;
  }

  public void activarDebuff() {
    this.debuff = true;
  }

  public void limpiarDebuff() {
    this.debuff = false;
  }

  public Posicion getPosicion() {
    return this.posicion;
  }

}
