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

  public void recibirCartas(List<Carta> cartas){
    this.cartas.addAll(cartas);
  }

  public void jugarCarta(Carta carta, Tablero tablero, Jugador jugador){
    if(this.cartas.contains(carta)){
      this.cartas.remove(carta);
      carta.jugarCarta(tablero,jugador);
    }
  }

  public int getCantCartas() {
    return this.cartas.size();
  }
}
