package edu.fiuba.algo3.falopa;

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

  public Carta obtenerCartaEnMano(int indiceCarta) {
    return this.mano.getCarta(indiceCarta);
  }

  public int cantidadCartasEnMano() {
    return this.mano.cantidad();
  }

  public int cartasEnElMazo() {
    return mazo.cantCartas();
  }
}
