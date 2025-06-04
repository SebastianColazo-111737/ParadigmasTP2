package edu.fiuba.algo3.clases;
import java.util.List;
import java.util.ArrayList;

public class Mazo {
  private ArrayList<Carta> cartas;

  public Mazo(ArrayList<Carta> cartas) {
    this.cartas = cartas;
  }

  public int getCantCartas() {
    return this.cartas.size();
  }

  public Carta tomarUltimaCarta() {
    return this.cartas.remove(this.cartas.size() - 1);
  }

  public ArrayList<Carta> darCartas(int[] indices) {
    return null;
  }

  public List<Carta> darCartas(int cantidad){
    List<Carta> entregadas = new ArrayList<>();
    for (int i = 0; i < cantidad && !cartas.isEmpty(); i++) {
      entregadas.add(cartas.remove(cartas.size() - 1));
    }
    return entregadas;
  }

}
