package edu.fiuba.algo3.modelo.jugador.atril;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.cartas.especiales.CEspecial;

public class SeccionEspecial {
  private ArrayList<CEspecial> cartas;
  private Runnable observador;

  public SeccionEspecial() {
    this.cartas = new ArrayList<>();
  }

  public void agregarCarta(CEspecial carta) {
    this.cartas.add(carta);
    notificar();
  }

  public ArrayList<ICarta> limpiar() {
    ArrayList<ICarta> copia = new ArrayList<>(this.cartas);
    this.cartas.clear();
    notificar();
    return copia;
  }

  public boolean estaVacia(){
    return cartas.isEmpty();
  }

  public CEspecial getUltimaCarta(){
    if(cartas.isEmpty()) return null;
    return cartas.get(cartas.size() - 1);
  }

  public void agregarObservador(Runnable obs) {
    this.observador = obs;
  }

  private void notificar() {
    if (observador != null) {
      observador.run();
    }
  }

}
