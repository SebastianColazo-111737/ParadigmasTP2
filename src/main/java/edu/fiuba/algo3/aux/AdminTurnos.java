package edu.fiuba.algo3.aux;

public class AdminTurnos {
  private int turno;

  public AdminTurnos() {
    this.turno = 0;
  }

  public void siguienteTurno() {
    this.turno += 1;
  }

  public int getNumeroTurno() {
    return this.turno;
  }

  public int getIndiceJugadorActual() {
    return this.turno % 2;
  }

  public int getIndiceJugadorSiguiente() {
    return (this.turno + 1) % 2;
  }
}
