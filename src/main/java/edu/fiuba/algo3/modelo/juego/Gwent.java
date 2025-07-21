package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posiciones.*;
import java.util.ArrayList;
import java.util.List;

public class Gwent {
  private AdminTurnos adminTurnos;
  private ArrayList<Jugador> jugadores;

  public Gwent(Jugador jugador1, Jugador jugador2) {
    this.jugadores = new ArrayList<>();
    jugadores.add(jugador1);
    jugadores.add(jugador2);

    this.adminTurnos = new AdminTurnos(this.jugadores);
  }

  private void reiniciarRonda() {
    this.adminTurnos.reiniciarRonda();
    if (this.getJugadorActual().puntajeTablero() < this.getJugadorProximo().puntajeTablero()) {
      this.getJugadorActual().reducirVida();
    } else {
      this.getJugadorProximo().reducirVida();
    }
    for (Jugador j : this.jugadores) {
      j.limpiarTodo();
    }
    // this.repartirCartasALosJugadores();
  }

  public boolean esFinDePartida() {
    return !this.getJugadorActual().estaVivo() || !this.getJugadorProximo().estaVivo();
  }

  public Jugador getGanador() {
    if (!this.esFinDePartida()) {
      return null;
    }
    return this.getJugadorActual().estaVivo() ? this.getJugadorActual() : this.getJugadorProximo();
  }

  public void chequearEstadoRonda() {
    if (this.esFinDePartida()) {
      return;
    }

    if (this.adminTurnos.esFinRonda()) {
      this.reiniciarRonda();
      return;
    }

    if (this.getJugadorActual().manoVacia()) {
      this.adminTurnos.finTurnoJugadorActual();

    }
  }

  public void repartirCartasALosJugadores() {
    for (Jugador jugador : this.jugadores) {
      jugador.robarCartasDelMazo(10);
    }
  }

  public Jugador getJugadorActual() {
    return this.adminTurnos.getJugadorActual();
  }

  public Jugador getJugadorProximo() {
    return this.adminTurnos.getJugadorProximo();
  }

  public List<Jugador> getJugadores() {
    return this.jugadores;
  }

  public void jugarCarta(ICarta carta, Posicion posicion) {
    Jugador jugador = this.getJugadorActual();
    jugador.jugarCarta(carta, this.getJugadorProximo(), posicion, this.adminTurnos);
  }

  public void finalizarPariticipacionDelJugadorActual() {
    this.adminTurnos.finTurnoJugadorActual();
  }

  public ArrayList<ICarta> getCartasDescarteJugadorActual() {
    return this.getJugadorActual().descarte().getCartas();
  }

}
