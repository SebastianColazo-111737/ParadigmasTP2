package edu.fiuba.algo3.clases;

import java.util.List;

public class Jugador {
  private String nombre;
  private Mazo mazo;
  private Mano mano;

  public Jugador(String nombre, Mazo mazo) {
    this.mazo = mazo;
    this.nombre = nombre;
    this.mano = new Mano();
  }

  public void repartirMano() {
    for (int i = 0; i < 10; i++) {
      this.mano.addCarta(mazo.tomarUltimaCarta());
    }
  }

  public void robarCartas(int cantidad) {
    List<Carta> cartasRobadas = this.mazo.darCartas(cantidad);
    this.mano.recibirCartas(cartasRobadas);
  }

  public Carta obtenerCartaEnMano(int indiceCarta) {
    return this.mano.getCarta(indiceCarta);
  }

  public void jugarCarta(Carta carta, Tablero tablero) {
    this.mano.jugarCarta(carta, tablero, this);
  }

  public int cartasEnElMazo() {
    return mazo.getCantCartas();
  }

  public int cantidadCartasEnMano() {
    return mano.getCantCartas();
  }

  public Mazo getMazo() {
    return this.mazo;
  }

  public Mano getMano() {
    return this.mano;
  }
}
