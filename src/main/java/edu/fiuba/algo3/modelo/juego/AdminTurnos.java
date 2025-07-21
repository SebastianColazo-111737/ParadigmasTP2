package edu.fiuba.algo3.modelo.juego;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class AdminTurnos {
  private int turno;
  private ArrayList<Jugador> jugadores;
  private boolean finTurnoJ1 = false;
  private boolean finTurnoJ2 = false;

  public AdminTurnos(ArrayList<Jugador> jugadores) {
    this.turno = 0;
    this.jugadores = jugadores;
  }

  public void siguienteTurno() {
    int proximo = getIndiceProximoJugador();
    if ((proximo == 0 && finTurnoJ1) || (proximo == 1 && finTurnoJ2)) {
      return;
    }
    this.turno += 1;
  }

  public void reiniciarRonda() {
    this.turno = 0;
    this.finTurnoJ1 = false;
    this.finTurnoJ2 = false;
  }

  public boolean esFinRonda() {
    return this.finTurnoJ1 && this.finTurnoJ2;
  }

  private int getIndiceDelJugadorActual() {
    return this.turno % 2;
  }

  private int getIndiceProximoJugador() {
    return (this.turno + 1) % 2;
  }

  public Jugador getJugadorActual() {
    return this.jugadores.get(this.getIndiceDelJugadorActual());
  }

  public Jugador getJugadorProximo() {
    return this.jugadores.get(this.getIndiceProximoJugador());
  }

  public void finTurnoJugadorActual() {
    if (this.getIndiceDelJugadorActual() == 1) {
      this.finTurnoJ2 = true;
    } else {
      this.finTurnoJ1 = true;
    }
    this.siguienteTurno();

  }

}
