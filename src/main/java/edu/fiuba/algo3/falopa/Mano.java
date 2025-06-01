package edu.fiuba.algo3.falopa;

import java.util.ArrayList;

public class Mano {
  public ArrayList<Carta> cartas;

  public Mano() {
    this.cartas = new ArrayList<Carta>();
  }

  public void addCarta(Carta carta) {
    this.cartas.add(carta);
  }

  public Carta getCarta(int indice) {
    return this.cartas.get(indice);
  }

  public int cantidad() {
    return this.cartas.size();
  }
}
