package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.juego.AdminTurnos;
import edu.fiuba.algo3.modelo.juego.AdminturnosTodosPasaronDeTurno;
import edu.fiuba.algo3.modelo.juego.Gwent;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vistas.Contenedores.VistaAtril;

public class ControladorTurnos {
  private final Gwent juego;

  public ControladorTurnos(Gwent juego) {
    this.juego = juego;
  }

  public Jugador jugadorActual() {
    return juego.getJugadorActual();
  }

  public Jugador jugadorProximo() {
    return juego.getJugadorProximo();
  }

  public void AvanzarTurno() {
    juego.pasarTurno();
    System.out.println("Nuevo turno: " + juego.getJugadorActual());
  }

  public void finalizarParticipacion() {
    boolean rondaTerminada = juego.finalizarParticipacion();

    if (rondaTerminada) {
      System.out.println("RONDA TERMINADA");
      juego.reiniciarRonda();
    }
  }
}

