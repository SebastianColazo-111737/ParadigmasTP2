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

  public int cantidadCartas() {
    return this.cartas.size();
  }

  public Carta retitarUltimaCarta() {
    return this.cartas.remove(this.cartas.size() - 1);
  }

  public ArrayList<Carta> getSeccion() {
    return this.cartas;
  }
}
