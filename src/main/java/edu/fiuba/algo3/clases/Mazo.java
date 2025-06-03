package edu.fiuba.algo3.clases;

import java.util.ArrayList;

public class Mazo {
  private ArrayList<Carta> cartas;

  public Mazo(ArrayList<Carta> cartas) {
    this.cartas = cartas;
  }

  public int cantCartas() {
    return this.cartas.size();
  }

  public Carta tomarUltimaCarta() {
    return this.cartas.remove(this.cartas.size() - 1);
  }

  public ArrayList<Carta> darCartas(int[] indices) {
    return null;
  }

}
