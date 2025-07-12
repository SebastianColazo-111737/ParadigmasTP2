
package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.cartas.ICarta;

import java.util.ArrayList;
import java.util.List;

public class Descarte {
  private List<ICarta> cartas;
  private List<Runnable> observadores = new ArrayList<>();

  public Descarte() {
    this.cartas = new ArrayList<>();
  }

  public void agregarObservador(Runnable obs) {
    this.observadores.add(obs);
  }

  private void notificar() {
    for (Runnable obs : observadores) {
      obs.run();
    }
  }

  public void agregarCarta(ICarta carta) {
    this.cartas.add(carta);
    notificar();
  }

  public void agregarCarta(List<ICarta> cartas) {
    this.cartas.addAll(cartas);
    notificar();
  }

  public List<ICarta> getCartas() {
    return this.cartas;
  }

  public int getCantidadCartas() {
    return this.cartas.size();
  }

  public void removerCarta(ICarta carta) {
    this.cartas.remove(carta);
    notificar();
  }
}
