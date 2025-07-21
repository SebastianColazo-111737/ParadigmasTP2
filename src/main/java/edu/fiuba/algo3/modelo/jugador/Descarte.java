
package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.cartas.ICarta;

import java.util.ArrayList;
import java.util.List;

public class Descarte {
  private ArrayList<ICarta> cartas;

  public Descarte() {
    this.cartas = new ArrayList<>();
  }

  public void agregarCarta(ICarta carta) {
    this.cartas.add(carta);
  }

  public void agregarCarta(List<ICarta> cartas) {
    this.cartas.addAll(cartas);
  }

  public ArrayList<ICarta> getCartas() {
    return this.cartas;
  }

  public int getCantidadCartas() {
    return this.cartas.size();
  }

  public void removerCarta(ICarta carta) {
    this.cartas.remove(carta);
  }
}
