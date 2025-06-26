package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.modelo.posiciones.*;
import java.util.ArrayList;
import java.util.List;

public class Gwent {
  private AdminTurnos<Jugador> adminTurnos;
  private List<Jugador> jugadores;

  public Gwent(Jugador jugador1, Jugador jugador2) {
    this.jugadores = new ArrayList<>();
    jugadores.add(jugador1);
    jugadores.add(jugador2);

    this.adminTurnos = new AdminTurnos<>(this.jugadores);
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

  public void setJugadorActual(Jugador jugador) {
    this.adminTurnos.setJugadorActual(jugador);
  }

  public void pasarTurno(){
    if(todosPasaron()){
      throw new AdminturnosTodosPasaronDeTurno("Todos los jugadores pasaron de turno");
    }
    adminTurnos.proximoTurno();
  }

  public void jugarCarta(ICarta carta, Posicion posicion) {
    Jugador jugador = adminTurnos.getJugadorActual();
    jugador.jugarCarta(carta, this.adminTurnos.getJugadorProximo(), posicion);
    // adminTurnos.proximoTurno();
  }

  public boolean finalizarParticipacion(){
    Jugador juego = adminTurnos.getJugadorActual();
    adminTurnos.jugadorPasaTurno(juego);

    boolean rondaTerminada = adminTurnos.todosPasaronTurno();
    if(!rondaTerminada) adminTurnos.proximoTurno();
    return rondaTerminada;
  }

  public boolean todosPasaron(){
    return adminTurnos.todosPasaronTurno();
  }

  public void reiniciarRonda(){
    adminTurnos.reiniciarAdminTurnos();
  }

}
