package edu.fiuba.algo3.Controller;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.juego.Gwent;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Mano;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

public class GameController {
  private Gwent juego;
  private Jugador j1;
  private Jugador j2;

  public GameController() {
    this.juego = Generador.juego();
    this.j1 = this.juego.getJugadorActual();
    this.j2 = this.juego.getJugadorProximo();
  }

  public void jugar(ICarta carta, Posicion posicion) {

    if (carta.getTipo() == null) {
      System.out.print("La carta no tiene tipo");
      this.juego.jugarCarta(carta, null);
      return;
    }
    this.juego.jugarCarta(carta, posicion);
  }

  public ArrayList<Seccion> getTodasLasSecciones() {

    ArrayList<Seccion> s = new ArrayList<>();

    s.addAll(j2.atril().getSecciones());
    s.addAll(j1.atril().getSecciones());

    return s;
  }

  public Mano getManoJ1() {
    return this.j1.mano();
  }

  public Mano getManoJ2() {
    return this.j2.mano();
  }

  public Jugador getJugador1() {
    return j1;
  }

  public Jugador getJugador2() {
    return j2;
  }

  public Jugador getJugadorActual() {
    return this.juego.getJugadorActual();
  }

  public void finalizarTurnoJugadorPlayer() {
    this.juego.finalizarPariticipacionDelJugadorActual();
  }

  public void chequearEstado() {
    this.juego.chequearEstadoRonda();
  }

  public ArrayList<ICarta> getCartasDelDescarteJugadorActual() {
    return this.juego.getCartasDescarteJugadorActual();
  }

  public boolean esFinDePartida() {
    return this.juego.esFinDePartida();
  }

  public Jugador getGanador() {
    return this.juego.getGanador();
  }
}
