package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.cartas.*;
import edu.fiuba.algo3.modelo.cartas.especiales.CEspecial;
import edu.fiuba.algo3.modelo.jugador.atril.Atril;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.modelo.posiciones.*;
import java.util.ArrayList;
import java.util.List;

public class Jugador {
  private Mazo mazo;
  private Mano mano;
  private Atril atril;

  public Jugador(Mazo mazo, Mano mano, Atril atril) {
    this.mazo = mazo;
    this.mano = mano;
    this.atril = atril;
  }

  public void robarCartasDelMazo(int cantidad) {
    List<ICarta> cartasDelMazo = this.mazo.darCartas(cantidad);
    this.mano.agregarCarta(cartasDelMazo);
  }

  public void cambiarCartaDeLaManoAlMazo(ICarta carta) {
    mano.removerCarta(carta);

    ICarta cartaDelMazo = this.mazo.cambiarCarta(carta);
    agregarCartaALaMano(cartaDelMazo);
  }

  public void activarDebuff(ArrayList<Posicion> posicionesAfectadas) {
    this.atril.activarDebuff(posicionesAfectadas);
  }

  public void duplicarPuntos(ArrayList<Posicion> posicionesAfectadas) {
    this.atril.duplicarPuntos(posicionesAfectadas);
  }

  public void limpiarDebuff(ArrayList<Posicion> posicionesAfectadas) {
    this.atril.limpiarDebuff(posicionesAfectadas);
  }

  public void agregarCartaALaMano(ICarta carta) {
    this.mano.agregarCarta(carta);
  }

  public boolean lePertenece(Seccion seccion) {
    return this.atril.contiene(seccion);
  }

  public void jugarCarta(ICarta carta, Jugador jugadorSiguiente, Posicion tipo) {
    mano.removerCarta(carta);

    try {
      carta.jugar(this, jugadorSiguiente, tipo);
    } catch (Exception e) {
      mano.agregarCarta(carta);
      throw e;
    }

  }

  public void colocarUnidad(ICarta carta, Posicion posicion) {
    atril.colocarCarta(carta, posicion);
  }

  public void colocarCartaEspecial(CEspecial carta) {
    atril.colocarEspecial(carta);
  }

  public Atril atril() {
    return this.atril;
  }

  public Mano mano() {
    return this.mano;
  }

  // public int getPuntajeActual(){
  // return atril.getPuntajeActual();
  // }
}
