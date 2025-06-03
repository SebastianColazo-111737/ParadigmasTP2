package edu.fiuba.algo3.clases;

import java.util.ArrayList;

public class Seccion {
  private ArrayList<Carta> cartasJugadas;
  private Jugador jugador;

  public Seccion() {
    this.cartasJugadas = new ArrayList<>();
  }

  public Seccion(Jugador jugador){
    this.jugador = jugador;
    this.cartasJugadas = new ArrayList<>();
  }

  public Jugador getJugador(){
    return this.jugador;
  }

  public void addCarta(Carta carta) {
    this.cartasJugadas.add(carta);
  }

  public int cantidadCartas() {
    return this.cartasJugadas.size();
  }

  public Carta retirarUltimaCarta() {
    return this.cartasJugadas.remove(this.cartasJugadas.size() - 1);
  }

  public ArrayList<Carta> getSeccion() {
    return this.cartasJugadas;
  }

  public boolean perteneceAJugador(Jugador jugador){
    return this.jugador == jugador;
  }

  public int obtenerPuntaje(){
    int total = 0;
    for (Carta carta : cartasJugadas){
      total += carta.getValorAtaque();
    }
    return  total;
  }

}
