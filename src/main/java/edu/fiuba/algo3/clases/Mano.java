package edu.fiuba.algo3.clases;

import java.util.List;
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

  public void recibirCartas(List<Carta> cartas) {
    this.cartas.addAll(cartas);
  }

  public void quitarCarta(Carta carta){
    cartas.remove(carta);
  }

  public int getCantCartas() {
    return this.cartas.size();
  }
}
