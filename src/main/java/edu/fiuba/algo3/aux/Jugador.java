package edu.fiuba.algo3.aux;

import java.util.List;

public class Jugador {
  private String nombre;
  private Mazo mazo;
  private Mano mano;
  private Descarte descarte;

  public Jugador(String nombre, Mazo mazo) {
    this.mazo = mazo;
    this.nombre = nombre;
    this.mano = new Mano();
    this.descarte = new Descarte();
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

  public Boolean jugarCarta(Carta carta, Tablero tablero, Posicion posicion) {
    Boolean seColoco = carta.jugar(tablero, this, posicion);
    if (seColoco) {
      descartarCarta(carta);
    }
    return seColoco;
  }

  public Boolean jugarCartaEspecial(Especial carta, Tablero tablero, ZonaEspeciales zonaEspeciales){
    Boolean seColoco = carta.jugarEspecial(tablero, this, zonaEspeciales);
    if(seColoco){
      descartarCarta(carta);
    }
    return seColoco;
  }



  public void descartarCarta(Carta carta) {
    mano.quitarCarta(carta);
    this.descarte.descartar(carta);
  }

  public int cartasEnElMazo() {
    return mazo.getCantCartas();
  }

  public int cantidadCartasEnMano() {
    return mano.getCantCartas();
  }

  public int cantidadCartasEnDescarte() {
    return this.descarte.getCantCartasEnPila();
  }

  public Mazo getMazo() {
    return this.mazo;
  }

  public Mano getMano() {
    return this.mano;
  }

  public Descarte getDescarte() {
    return this.descarte;
  }
}
