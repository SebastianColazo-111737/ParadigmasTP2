package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.cartas.*;
import edu.fiuba.algo3.modelo.cartas.especiales.CEspecial;
import edu.fiuba.algo3.modelo.cartas.unidades.Unidad;
import edu.fiuba.algo3.modelo.juego.AdminTurnos;
import edu.fiuba.algo3.modelo.jugador.atril.Atril;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.modelo.posiciones.*;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

public class Jugador {
  private Mazo mazo;
  private Mano mano;
  private Atril atril;
  private Descarte descarte;
  private String nombre;
  // private int puntos;
  private int vidas;

  public Jugador(Mazo mazo, Mano mano, Atril atril, String nombre) {
    this.nombre = nombre;
    this.mazo = mazo;
    this.mano = mano;
    this.atril = atril;
    this.descarte = new Descarte();
    // this.puntos = 0;
    this.vidas = 2;
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

  public void quemarCartaMasFuerte() {
    this.atril.quemarCartaMasFuerte();
  }

  public void duplicarPuntos(Posicion posicion) {
    this.atril.duplicarPuntos(posicion);
  }

  public void limpiarDebuff(ArrayList<Posicion> posicionesAfectadas) {
    this.atril.limpiarDebuff(posicionesAfectadas);
  }

  public void limpiarCartaEspecial() {
    atril.limpiarCartaEspecial();
  }

  public void agregarCartaALaMano(ICarta carta) {
    this.mano.agregarCarta(carta);
  }

  public boolean lePertenece(Seccion seccion) {
    return this.atril.contiene(seccion);
  }

  public void jugarCarta(ICarta carta, Jugador jugadorSiguiente, Posicion tipo, AdminTurnos turnos) {
    if (!mano.contieneA(carta)) {
      throw new ManoNoContieneCartaException("no puede jugar una carta que no es suya");
      //System.out.print("no puede jugar una carta que no es suya");
      //return;
    }
    try {
      carta.jugar(this, jugadorSiguiente, tipo);
    } catch (Exception e) {
      throw e;
    }

    mano.removerCarta(carta);
    turnos.siguienteTurno();
  }

  public void colocarUnidad(ICarta carta, Posicion posicion) {
    atril.colocarCarta(carta, posicion);

  }

  public void colocarCartaEspecial(CEspecial carta) {
    atril.colocarEspecial(carta);

  }

  public void limpiarTodo() {
    // this.puntos += this.atril().getPuntajeActual();
    List<ICarta> descartadas = this.atril.descartarCartas();
    this.descarte.agregarCarta(descartadas);

  }

  public Atril atril() {
    return this.atril;
  }

  public Descarte descarte() {
    return this.descarte;
  }

  public Mano mano() {
    return this.mano;
  }

  public Mazo mazo() {
    return this.mazo;
  }

  public String nombre() {
    return this.nombre;
  }

  public boolean manoVacia() {
    return this.mano.getCantidadCartas() == 0;
  }

  // public int puntajeActual() {
  // return this.atril.getPuntajeActual() + this.puntos;
  // }

  public void sacarCartaDelDescarte(ICarta carta) {
    this.descarte.removerCarta(carta);
  }

  public void reducirVida() {
    this.vidas--;
  }

  public int puntajeTablero() {
    return this.atril.getPuntajeActual();
  }

  public int getVida() {
    return this.vidas;
  }

  public boolean estaVivo() {
    return this.vidas > 0;
  }
}
