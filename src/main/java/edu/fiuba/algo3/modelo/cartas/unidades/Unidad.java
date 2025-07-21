package edu.fiuba.algo3.modelo.cartas.unidades;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.jugador.Puntaje;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

import java.util.ArrayList;

public abstract class Unidad implements ICarta {

  protected String nombre;
  protected Puntaje puntaje;
  protected ArrayList<Posicion> posicionesDisponibles;

  public Unidad(String nombre, Puntaje puntaje, Posicion posicicon) {
    this.nombre = nombre;
    this.puntaje = puntaje;

    this.posicionesDisponibles = new ArrayList<>();
    this.posicionesDisponibles.add(posicicon);
  }

  public boolean sePuedeColocar(Posicion posicion) {
    for (Posicion posicionesDisponibles : posicionesDisponibles) {
      if (posicionesDisponibles.esCompatible(posicion)) {
        return true;
      }
    }
    return false;
  }

  public ArrayList<Posicion> getTipo() {
    return this.posicionesDisponibles;
  }

  public Boolean masFuerteQue(Unidad unidad) {
    return (unidad == null) || this.getPuntaje().getPuntajeActual() > unidad.getPuntaje().getPuntajeActual();
  }

  public Puntaje getPuntaje() {
    return this.puntaje;
  }

  public int getPuntajeTotal(Seccion seccion) {
    return this.puntaje.getPuntajeActual();
  }

  public boolean esLegendaria() {
    return false;
  }
}
