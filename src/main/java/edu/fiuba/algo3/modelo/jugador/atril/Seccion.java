package edu.fiuba.algo3.modelo.jugador.atril;

import edu.fiuba.algo3.modelo.cartas.unidades.Animador;
import edu.fiuba.algo3.modelo.cartas.unidades.Legendaria;
import edu.fiuba.algo3.modelo.cartas.unidades.Unidad;
import edu.fiuba.algo3.modelo.jugador.Puntaje;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Seccion {
  private Posicion posicion;
  private List<Unidad> unidadesColocadas;
  private List<Runnable> observadores = new ArrayList<>();
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

  public void agregarObservador(Runnable obs) {
    this.observadores.add(obs);
  }

  private void notificar() {
    for (Runnable obs : observadores) {
      obs.run();
    }
  }

  public void colocarUnidad(Unidad unidad) {
    if (!unidad.sePuedeColocar(posicion)) {
      throw new SeccionNoPermiteColocarUnidadesConPosicionIncompatible("");
    }
    unidadesColocadas.add(unidad);
    notificar();
  }

  public Unidad tomarCartaMasFuerte() {
    if (this.unidadesColocadas.size() == 0) {
      return null;
    }
    Unidad fuerte = null;
    for (Unidad unidad : this.unidadesColocadas) {

      if (!(unidad instanceof Legendaria) && unidad.masFuerteQue(fuerte)) {
        fuerte = unidad;
      }

    }
    return fuerte;
  }

  public void removerCarta(Unidad carta) {
    if (!this.contieneCarta(carta)) return;
    this.unidadesColocadas.remove(carta);
    notificar();
  }

  public Puntaje calcularPuntajeActualUnidades() {
    int puntajeTotal = 0;

    if (this.debuff) {
      for (Unidad unidad : unidadesColocadas) {
        if (unidad instanceof Legendaria) {
          puntajeTotal += unidad.getPuntaje().getPuntajeActual();
        } else {
          puntajeTotal += 1;
        }
      }
      return new Puntaje(puntajeTotal);
    }

    int cantAnimadoresEnSeccion = (int) unidadesColocadas.stream()
        .filter(u -> u instanceof Animador)
        .count();

    for (Unidad unidad : unidadesColocadas) {
      if (unidad instanceof Animador)
        puntajeTotal += unidad.getPuntajeTotal(this) * this.duplicadores;

      else if (unidad instanceof Legendaria)
        puntajeTotal += unidad.getPuntajeTotal(this);
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
      Unidad carta = unidadesColocadas.remove(0);
      descartadas.add(carta);
      System.out.println("Se descarto: "+ carta);

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
