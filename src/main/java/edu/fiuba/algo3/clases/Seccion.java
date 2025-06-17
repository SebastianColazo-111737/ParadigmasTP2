package edu.fiuba.algo3.clases;

import edu.fiuba.algo3.clases.Cartas.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import edu.fiuba.algo3.clases.Tipos.*;

public class Seccion {
  private ArrayList<Unidad> unidadesJugadas;
  private Tipo tipo;

  public Seccion(Tipo posicion) {
    this.unidadesJugadas = new ArrayList<>();
    this.tipo = posicion;
  }

  public Boolean colocarUnidad(Unidad unidad) {

    this.unidadesJugadas.add(unidad);
    return true;
  }

  public int getCantUnidades() {
    return this.unidadesJugadas.size();
  }

  public ArrayList<Unidad> getUnidadesSeccion() {
    return this.unidadesJugadas;
  }

  public int obtenerPuntaje() {
    int total = 0;
    for (Unidad unidad : unidadesJugadas) {
      total += unidad.getPuntosModificados();
    }
    return total;
  }

  public ArrayList<Carta> limpiar() {
    ArrayList<Carta> copia = new ArrayList<>(this.unidadesJugadas);
    this.unidadesJugadas.clear();
    return copia;
  }

  public Boolean compararCon(ArrayList<Tipo> tipo) {
    return this.tipo.esIgual(tipo);
  }

  // public void aplicarEfectoNieve() {
  // for (Unidad unidad : this.unidadesJugadas) {
  // unidad.modificarPuntos(1);
  // }
  // }

  public Tipo getTipo() {
    return this.tipo;
  }

  public void desactivarEfectoNieve() {
    for (Unidad unidad : this.unidadesJugadas) {
      unidad.reiniciarPuntos();
    }
  }

  public void aplicarEfectoTierraArrasada(Jugador jugador) {
    int maxPuntos = this.unidadesJugadas.stream()
        .mapToInt(Unidad::getPuntosModificados)
        .max()
        .orElse(0);

    List<Unidad> aEliminar = this.unidadesJugadas.stream()
        .filter(u -> u.getPuntosModificados() == maxPuntos)
        .collect(Collectors.toList());

    for (Unidad unidad : aEliminar) {
      this.unidadesJugadas.remove(unidad);
      jugador.descartarCarta(unidad);
    }
  }

}
