package edu.fiuba.algo3.falopa;

import java.util.ArrayList;

public class Seccion {
  private ArrayList<Carta> cartas;

  public Seccion() {
    this.cartas = new ArrayList<>();
  }

  public void addCarta(Carta carta) {
    this.cartas.add(carta);
  }

  public ArrayList<Carta> getSeccion() {
    return this.cartas;
  }
}
